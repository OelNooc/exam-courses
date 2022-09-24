package cl.nooc.examencentrodeformacinfuturo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_detail")
data class CourseDetail(
    val description: String,
    @PrimaryKey
    val id: String,
    val image: String,
    val minimumSkill: String,
    val modality: String,
    val scholarshipsAvailable: Boolean,
    val start: String,
    val title: String,
    val tuition: String,
    val weeks: Int
)