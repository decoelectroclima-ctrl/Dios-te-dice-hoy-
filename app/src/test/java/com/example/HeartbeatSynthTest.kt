package com.example

import com.example.util.HeartbeatSynth
import org.junit.Assert.*
import org.junit.Test
import kotlin.math.abs

class HeartbeatSynthTest {

    @Test
    fun testBufferLength() {
        val bpm = 72
        val beats = 4
        val buffer = HeartbeatSynth.renderCycle(bpm, beats)
        val expectedLength = ((60.0 / bpm) * 44100).toInt() * beats
        assertEquals(expectedLength.toDouble(), buffer.size.toDouble(), 1.0)
    }

    @Test
    fun testPeakAmplitude() {
        val buffer = HeartbeatSynth.renderCycle(72)
        for (sample in buffer) {
            assertTrue(abs(sample.toInt()) <= 32767)
        }
    }

    @Test
    fun testDeterminism() {
        val buffer1 = HeartbeatSynth.renderCycle(72, 4)
        val buffer2 = HeartbeatSynth.renderCycle(72, 4)
        assertArrayEquals(buffer1, buffer2)
    }
}
