package com.example

import com.example.util.HeartbeatSynth
import org.junit.Assert.*
import org.junit.Test
import kotlin.math.abs

class HeartbeatSynthTest {

    @Test
    fun testBufferLength() {
        val bpm = 72
        val beats = 8
        val buffer = HeartbeatSynth.renderCycle(bpm, beats)
        val expectedLength = ((60.0 / bpm) * 44100).toInt() * beats
        assertEquals(expectedLength.toDouble(), buffer.size.toDouble(), 1.0)
    }

    @Test
    fun testPeakAmplitude() {
        val buffer = HeartbeatSynth.renderCycle(72)
        for (sample in buffer) {
            assertTrue(abs(sample) <= 32767 * 0.9)
        }
    }

    @Test
    fun testDeterminism() {
        val seed = 123L
        val buffer1 = HeartbeatSynth.renderCycle(72, seed = seed)
        val buffer2 = HeartbeatSynth.renderCycle(72, seed = seed)
        assertArrayEquals(buffer1, buffer2)
    }
}
