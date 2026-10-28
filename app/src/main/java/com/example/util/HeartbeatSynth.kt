package com.example.util

import kotlin.math.*
import java.util.Random

data class HeartbeatConfig(
    val sampleRate: Int = 44100,
    val lubFreqStart: Double = 70.0,
    val lubFreqEnd: Double = 45.0,
    val lubDuration: Double = 0.08,
    val dubFreqStart: Double = 90.0,
    val dubFreqEnd: Double = 60.0,
    val dubDuration: Double = 0.06,
    val noiseDuration: Double = 0.025,
    val drive: Double = 2.5
)

object HeartbeatSynth {
    private val config = HeartbeatConfig()

    fun renderCycle(bpm: Int, beats: Int = 2, sampleRate: Int = 44100, seed: Long = 1L): ShortArray {
        return try {
            val random = Random(seed)
            val safeBpm = bpm.coerceIn(40, 180)
            val secPerCycle = 60.0 / safeBpm
            val sistole = (0.30 - (safeBpm - 60) * 0.0011).coerceIn(0.18, 0.32)
            val numSamplesPerCycle = (secPerCycle * sampleRate).toInt()
            val totalSamples = (numSamplesPerCycle * beats).coerceIn(100, 88200)
            val buffer = FloatArray(totalSamples)

            for (b in 0 until beats) {
                val offset = b * numSamplesPerCycle
                val variation = 1.0 + (random.nextDouble() * 0.04 - 0.02)
                
                // "Lub"
                addTone(buffer, offset, config.lubFreqStart * variation, config.lubFreqEnd * variation, (config.lubDuration * sampleRate).toInt(), 1.0)
                // "Dub"
                addTone(buffer, offset + (sistole * sampleRate).toInt(), config.dubFreqStart * variation, config.dubFreqEnd * variation, (config.dubDuration * sampleRate).toInt(), 0.65)
            }

            var maxVal = 0.0001f
            for (i in buffer.indices) maxVal = max(maxVal, abs(buffer[i]))
            val shortResult = ShortArray(totalSamples)
            val driveVal = config.drive
            val tanhDrive = tanh(driveVal)
            for (i in buffer.indices) {
                val normalized = tanh(driveVal * (buffer[i] / maxVal * 0.85)) / tanhDrive
                shortResult[i] = (normalized * 32767).toInt().coerceIn(-32768, 32767).toShort()
            }
            shortResult
        } catch (_: Throwable) {
            ShortArray(100)
        }
    }

    private fun addTone(buffer: FloatArray, start: Int, freqStart: Double, freqEnd: Double, duration: Int, amp: Double) {
        var phase = 0.0
        for (i in 0 until duration) {
            if (start + i >= buffer.size) break
            val t = i.toDouble() / duration
            val freq = freqStart + (freqEnd - freqStart) * t
            buffer[start + i] += (sin(phase) * amp).toFloat()
            phase += 2.0 * PI * freq / 44100.0
        }
    }
}
