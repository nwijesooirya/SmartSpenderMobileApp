package com.example.trackly.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    val name: String,
    val iconResId: Int
) {
    companion object {
        val DEFAULT_CATEGORIES = listOf(
            "💰 Salary","💸 Bonus","'🌭 Food", "🚌 Transport", "💵 Bills", "🛝 Entertainment",
            "🛒 Shopping", "🧑  ️Health", "👩‍🏫 Education", "🤞 Other"
        )
    }
}
