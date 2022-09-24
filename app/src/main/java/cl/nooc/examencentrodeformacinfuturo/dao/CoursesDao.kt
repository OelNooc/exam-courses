package cl.nooc.examencentrodeformacinfuturo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.nooc.examencentrodeformacinfuturo.model.Course

@Dao
interface CoursesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCourses(coursesList: ArrayList<Course>)

    @Query("select * from courses")
    fun listCourses():LiveData<List<Course>>

    @Query("select count(id) from courses")
    fun count(): Int
}