package cl.nooc.examencentrodeformacinfuturo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import cl.nooc.examencentrodeformacinfuturo.room.CoursesDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseDetailsRepository(var context: Context) {

    private val dataBase = CoursesDB.getDB(context)

    fun add(courseDetail: CourseDetail){
        CoroutineScope(Dispatchers.IO).launch {
            dataBase.courseDetail().addDetails(courseDetail)
        }
    }

    fun list(): LiveData<List<CourseDetail>>{
        return dataBase.courseDetail().listDetails()
    }

    fun search(id:String): CourseDetail {
        return dataBase.courseDetail().search(id)
    }
}