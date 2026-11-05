package com.example.util

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicBoolean

class HeartbeatPlayer(
    private var onBeatListener: ((isLub: Boolean) -> Unit)? = null
) {
    private var audioTrack: AudioTrack? = null
    private val isPlaying = AtomicBoolean(false)
    private var currentBpm: Int = 66
    private var playJob: Job? = null
    private var currentVolume: Float = 1.0f
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, _ -> })

    fun setOnBeatListener(listener: ((isLub: Boolean) -> Unit)?) {
        this.onBeatListener = listener
    }

    fun start(bpm: Int = 66) {
        if (isPlaying.getAndSet(true)) return
        currentBpm = bpm.coerceIn(40, 180)

        playJob?.cancel()
        playJob = scope.launch {
            var track: AudioTrack? = null
            try {
                val sampleRate = HeartbeatSynth.SAMPLE_RATE
                val minBufferSize = AudioTrack.getMinBufferSize(
                    sampleRate,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT
                ).coerceAtLeast(4096)

                track = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(minBufferSize * 2)
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .build()

                if (track.state != AudioTrack.STATE_INITIALIZED) {
                    track.release()
                    isPlaying.set(false)
                    return@launch
                }

                track.setVolume(currentVolume)
                track.play()
                audioTrack = track

                val lub = HeartbeatSynth.lubSamples
                val dub = HeartbeatSynth.dubSamples

                // Interval between LUB and DUB (systole) ~ 140ms
                val systoleSilenceSamples = (0.14 * sampleRate).toInt()
                val systoleSilence = ShortArray(systoleSilenceSamples)

                while (isPlaying.get() && isActive) {
                    val beatStartTime = System.currentTimeMillis()

                    // 1. Play "LUB"
                    onBeatListener?.invoke(true)
                    track.write(lub, 0, lub.size)
                    track.write(systoleSilence, 0, systoleSilence.size)

                    // 2. Play "DUB"
                    onBeatListener?.invoke(false)
                    track.write(dub, 0, dub.size)

                    // 3. Calculate remaining diastole silence for target BPM
                    val totalBeatMs = (60000.0 / currentBpm).toLong()
                    val lubDurationMs = (lub.size * 1000L / sampleRate)
                    val systoleDurationMs = 140L
                    val dubDurationMs = (dub.size * 1000L / sampleRate)
                    val playedMs = lubDurationMs + systoleDurationMs + dubDurationMs
                    val remainingMs = (totalBeatMs - playedMs).coerceAtLeast(80L)

                    val diastoleSilenceSamples = ((remainingMs / 1000.0) * sampleRate).toInt()
                    val diastoleSilence = ShortArray(diastoleSilenceSamples)
                    track.write(diastoleSilence, 0, diastoleSilence.size)
                }
            } catch (_: Throwable) {
                isPlaying.set(false)
            } finally {
                try {
                    track?.apply {
                        if (playState == AudioTrack.PLAYSTATE_PLAYING) {
                            stop()
                        }
                        release()
                    }
                } catch (_: Throwable) {}
                if (audioTrack === track) {
                    audioTrack = null
                }
            }
        }
    }

    fun stop() {
        isPlaying.set(false)
        playJob?.cancel()
        playJob = null
        try {
            audioTrack?.apply {
                if (playState == AudioTrack.PLAYSTATE_PLAYING) {
                    stop()
                }
            }
        } catch (_: Throwable) {}
    }

    fun setBpm(bpm: Int) {
        currentBpm = bpm.coerceIn(40, 180)
    }

    fun setVolume(volume: Float) {
        currentVolume = volume.coerceIn(0.0f, 1.0f)
        try {
            audioTrack?.setVolume(currentVolume)
        } catch (_: Throwable) {}
    }

    fun release() {
        stop()
        try {
            audioTrack?.release()
        } catch (_: Throwable) {}
        audioTrack = null
    }

    fun isCurrentlyPlaying(): Boolean = isPlaying.get()
}
