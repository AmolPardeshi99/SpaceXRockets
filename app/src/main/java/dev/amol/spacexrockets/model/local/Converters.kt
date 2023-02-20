package dev.amol.spacexrockets.model.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun fromList(value: List<String>): String {
        return value.joinToString(",")
    }
}
