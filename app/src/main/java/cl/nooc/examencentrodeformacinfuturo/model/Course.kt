package cl.nooc.examencentrodeformacinfuturo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey
    val id: String,
    val image: String,
    val previewDescription: String,
    val start: String,
    val title: String,
    val weeks: Int
)