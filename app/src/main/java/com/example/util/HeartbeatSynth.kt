package com.example.util

import kotlin.math.*

object HeartbeatSynth {
    const val SAMPLE_RATE = 44100

    val lubSamples: ShortArray by lazy { renderSingleBeat(isLub = true) }
    val dubSamples: ShortArray by lazy { renderSingleBeat(isLub = false) }

    /**
     * Synthesizes a realistic, visceral heartbeat sound with enhanced acoustic presence
     * specifically engineered to be clearly heard on mobile phone and emulator speakers.
     */
    private fun renderSingleBeat(isLub: Boolean): ShortArray {
        val durationSec = if (isLub) 0.125 else 0.095
        val durationSamples = (durationSec * SAMPLE_RATE).toInt()
        val buffer = FloatArray(durationSamples)

        val freqStart = if (isLub) 135.0 else 165.0
        val freqEnd = if (isLub) 80.0 else 105.0
        val transientFreq = if (isLub) 480.0 else 620.0

        var phaseFund = 0.0
        var phaseHarm2 = 0.0
        var phaseHarm3 = 0.0
        var phaseTransient = 0.0

        for (i in 0 until durationSamples) {
            val t = i.toDouble() / durationSamples
            // Natural percussion envelope with punchy attack and smooth damping
            val envelope = sin(PI * t.pow(0.55)) * exp(-t * 3.8)

            // Frequency sweep from start to end
            val fFund = freqStart + (freqEnd - freqStart) * t
            val fHarm2 = fFund * 2.0
            val fHarm3 = fFund * 3.0

            // Impact transient click in the first 25ms for speaker audibility
            val transientEnv = if (t < 0.25) (1.0 - t / 0.25).pow(2.0) else 0.0

            val sample = (
                sin(phaseFund) * 0.45 +
                sin(phaseHarm2) * 0.35 +
                sin(phaseHarm3) * 0.12 +
                sin(phaseTransient) * 0.15 * transientEnv
            ) * envelope

            buffer[i] = sample.toFloat()

            phaseFund += 2.0 * PI * fFund / SAMPLE_RATE
            phaseHarm2 += 2.0 * PI * fHarm2 / SAMPLE_RATE
            phaseHarm3 += 2.0 * PI * fHarm3 / SAMPLE_RATE
            phaseTransient += 2.0 * PI * transientFreq / SAMPLE_RATE
        }

        // Normalize to peak amplitude of ~31500 (safe 16-bit PCM ceiling)
        var maxVal = 0.0001f
        for (v in buffer) {
            val a = abs(v)
            if (a > maxVal) maxVal = a
        }

        val result = ShortArray(durationSamples)
        val targetPeak = if (isLub) 31500f else 27000f
        for (i in buffer.indices) {
            val normalized = (buffer[i] / maxVal) * targetPeak
            result[i] = normalized.toInt().coerceIn(-32768, 32767).toShort()
        }
        return result
    }

    /**
     * Renders a multi-beat continuous cycle if needed for static playback
     */
    fun renderCycle(bpm: Int, beats: Int = 4, sampleRate: Int = SAMPLE_RATE): ShortArray {
        val safeBpm = bpm.coerceIn(40, 180)
        val secPerCycle = 60.0 / safeBpm
        val sistoleSec = 0.14 // Interval between Lub and Dub
        val numSamplesPerCycle = (secPerCycle * sampleRate).toInt()
        val totalSamples = numSamplesPerCycle * beats
        val cycle = ShortArray(totalSamples)

        val lub = lubSamples
        val dub = dubSamples
        val sistoleSamples = (sistoleSec * sampleRate).toInt()

        for (b in 0 until beats) {
            val offset = b * numSamplesPerCycle
            // Write LUB
            for (i in lub.indices) {
                if (offset + i < totalSamples) {
                    cycle[offset + i] = lub[i]
                }
            }
            // Write DUB
            val dubOffset = offset + sistoleSamples
            for (i in dub.indices) {
                if (dubOffset + i < totalSamples) {
                    cycle[dubOffset + i] = dub[i]
                }
            }
        }
        return cycle
    }
}
