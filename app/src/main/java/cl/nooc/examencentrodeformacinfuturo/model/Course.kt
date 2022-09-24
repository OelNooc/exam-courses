package cl.nooc.examencentrodeformacinfuturo.model

import androidx.room.Entity

@Entity(tableName = "courses")
data class Course(
    val id: String,
    val image: String,
    val previewDescription: String,
    val start: String,
    val title: String,
    val weeks: Int
)