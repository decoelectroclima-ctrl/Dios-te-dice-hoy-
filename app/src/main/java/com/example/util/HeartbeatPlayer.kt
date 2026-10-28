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
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { _, _ -> })

    fun start(bpm: Int) {
        if (isPlaying.getAndSet(true)) return
        currentBpm = bpm.coerceIn(40, 180)
        
        scope.launch {
            try {
                val pcmData = HeartbeatSynth.renderCycle(currentBpm)
                if (pcmData.isEmpty()) {
                    isPlaying.set(false)
                    return@launch
                }
                val track = AudioTrack.Builder()
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

                if (track.state == AudioTrack.STATE_INITIALIZED) {
                    track.write(pcmData, 0, pcmData.size)
                    track.setLoopPoints(0, pcmData.size, -1)
                    track.play()
                    audioTrack = track
                } else {
                    track.release()
                    isPlaying.set(false)
                }
            } catch (_: Throwable) {
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
        stop()
        start(bpm)
    }

    fun setVolume(volume: Float) {
        try {
            audioTrack?.setVolume(volume.coerceIn(0.0f, 0.8f))
        } catch (_: Throwable) {}
    }

    fun release() {
        try {
            audioTrack?.apply {
                stop()
                release()
            }
        } catch (_: Throwable) {}
        audioTrack = null
        isPlaying.set(false)
    }
}
