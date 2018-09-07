package com.example.sumitkumar1.weatherapp.utility

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class UtilsTest {

    @Test
    fun shouldReturnDayOfWeekAsSunday() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_WEEK, 1)

        assertEquals("Sunday", Utils.getDayOfWeek(calendar))
    }

    @Test
    fun shouldReturnValidWindDirectionForDegreeAbove_360() {
        assertEquals("SE", Utils.getWindDirection(450))
        assertEquals("NW", Utils.getWindDirection(-45))
        assertEquals("SW", Utils.getWindDirection(545))
        assertEquals("NW", Utils.getWindDirection(710))
    }
}