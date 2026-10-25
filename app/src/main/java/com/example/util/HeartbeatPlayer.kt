package com.example.util

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicBoolean

class HeartbeatPlayer {
    private var audioTrack: AudioTrack? = null
    private var isPlaying = AtomicBoolean(false)
    private var currentBpm: Int = 72
    private val scope = CoroutineScope(Dispatchers.Default + Job())

    fun start(bpm: Int) {
        if (isPlaying.getAndSet(true)) return
        currentBpm = bpm.coerceIn(40, 180)
        
        scope.launch {
            try {
                val pcmData = HeartbeatSynth.renderCycle(currentBpm)
                audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(44100)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(pcmData.size * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                audioTrack?.apply {
                    write(pcmData, 0, pcmData.size)
                    setLoopPoints(0, pcmData.size, -1)
                    play()
                }
            } catch (e: Exception) {
                isPlaying.set(false)
            }
        }
    }

    fun stop() {
        if (!isPlaying.getAndSet(false)) return
        release()
    }

    fun setBpm(bpm: Int) {
        if (!isPlaying.get()) return
        // Simplificación: parar y reiniciar con nuevo BPM
        stop()
        start(bpm)
    }

    fun setVolume(volume: Float) {
        audioTrack?.setVolume(volume.coerceIn(0.0f, 0.8f))
    }

    fun release() {
        audioTrack?.apply {
            try {
                stop()
                release()
            } catch (e: Exception) {}
        }
        audioTrack = null
    }
}
/*
Ejemplo de uso en un ViewModel o Composable:
val heartbeatPlayer = remember { HeartbeatPlayer() }
DisposableEffect(Unit) {
    heartbeatPlayer.start(72)
    onDispose { heartbeatPlayer.release() }
}
*/
