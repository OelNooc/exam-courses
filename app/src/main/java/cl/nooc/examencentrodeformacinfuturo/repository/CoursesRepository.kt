package cl.nooc.examencentrodeformacinfuturo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.room.CoursesDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoursesRepository(var context: Context) {

    private val dataBase = CoursesDB.getDB(context)

    fun add(coursesList: ArrayList<Course>){
        CoroutineScope(Dispatchers.IO).launch {
            dataBase.course().addCourses(coursesList)
        }
    }

    fun list(): LiveData<List<Course>>{
        return dataBase.course().listCourses()
    }

    fun count(): Int {
        var results = 0

        CoroutineScope(Dispatchers.IO).launch {
            results = dataBase.course().count()
        }
        return results
    }
}