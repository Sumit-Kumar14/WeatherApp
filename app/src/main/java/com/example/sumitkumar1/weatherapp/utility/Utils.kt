package com.example.sumitkumar1.weatherapp.utility

import java.util.*

class Utils {
    companion object {
        fun getDayOfWeek(calendar: Calendar): String {
            val day: Int = calendar.get(Calendar.DAY_OF_WEEK)
            return when (day) {
                Calendar.SUNDAY -> "Sunday"
                Calendar.MONDAY -> "Monday"
                Calendar.TUESDAY -> "Tuesday"
                Calendar.WEDNESDAY -> "Wednesday"
                Calendar.THURSDAY -> "Thursday"
                Calendar.FRIDAY -> "Friday"
                Calendar.SATURDAY -> "Saturday"
                else -> throw IllegalArgumentException("Invalid Date range")
            }
        }

        fun getWindDirection(degree: Int): String {
            var modulusDegree = degree % 360
            modulusDegree = if (modulusDegree < 0) {
                modulusDegree + 360
            } else {
                modulusDegree
            }

            return when (modulusDegree) {
                in 0..89 -> "NE"
                in 90..179 -> "SE"
                in 180..260 -> "SW"
                in 270..360 -> "NW"
                else -> throw IllegalArgumentException("Invalid Degree")
            }
        }
    }
}