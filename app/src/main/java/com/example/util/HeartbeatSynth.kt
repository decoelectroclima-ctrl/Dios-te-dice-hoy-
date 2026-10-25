package com.example.util

import kotlin.math.*
import java.util.Random

/**
 * Configuración para la síntesis del latido.
 * Valores ajustados para altavoces móviles.
 */
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

    fun renderCycle(bpm: Int, beats: Int = 8, sampleRate: Int = 44100, seed: Long = 1L): ShortArray {
        val random = Random(seed)
        val secPerCycle = 60.0 / bpm
        val sistole = (0.30 - (bpm - 60) * 0.0011).coerceIn(0.18, 0.32)
        val numSamplesPerCycle = (secPerCycle * sampleRate).toInt()
        val totalSamples = numSamplesPerCycle * beats
        val buffer = FloatArray(totalSamples)

        for (b in 0 until beats) {
            val offset = b * numSamplesPerCycle
            val variation = 1.0 + (random.nextDouble() * 0.04 - 0.02)
            
            // "Lub"
            addTone(buffer, offset, config.lubFreqStart * variation, config.lubFreqEnd * variation, (config.lubDuration * sampleRate).toInt(), 1.0)
            // "Dub"
            addTone(buffer, offset + (sistole * sampleRate).toInt(), config.dubFreqStart * variation, config.dubFreqEnd * variation, (config.dubDuration * sampleRate).toInt(), 0.65)
        }

        // Normalización y Saturación
        var max = 0.0f
        for (i in buffer.indices) max = max(max, abs(buffer[i]))
        for (i in buffer.indices) {
            buffer[i] = (tanh(config.drive * (buffer[i] / max * 0.85)) / tanh(config.drive)).toFloat()
        }

        return buffer.map { (it * 32767).toInt().toShort() }.toShortArray()
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
