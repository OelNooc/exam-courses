package cl.nooc.examencentrodeformacinfuturo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail

@Dao
interface CourseDetailDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun addDetails(courseDetail: CourseDetail)

    @Query("select * from course_detail where id = :id")
    fun search(id:String): CourseDetail

    @Query("select * from course_detail")
    fun listDetails(): LiveData<List<CourseDetail>>
}