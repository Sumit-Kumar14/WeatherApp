package com.example.sumitkumar1.weatherapp.utility

import java.util.*

class Utils {
    companion object {
        fun getDayOfWeek(): String {
            val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            when (day) {
                Calendar.SUNDAY -> return "Sunday"
                Calendar.MONDAY -> return "Monday"
                Calendar.TUESDAY -> return "Tuesday"
                Calendar.WEDNESDAY -> return "Wednesday"
                Calendar.THURSDAY -> return "Thursday"
                Calendar.FRIDAY -> return "Friday"
                Calendar.SATURDAY -> return "Saturday"
            }
            return ""
        }

        fun getWindDirection(degree: Int): String {
            when (degree) {
                in 0..89 -> return "NE"
                in 90..179 -> return "SE"
                in 180..260 -> return "SW"
                in 270..360 -> return "NW"
            }
            return "NE"
        }
    }
}