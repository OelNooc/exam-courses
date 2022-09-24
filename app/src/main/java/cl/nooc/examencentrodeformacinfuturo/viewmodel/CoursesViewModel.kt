package cl.nooc.examencentrodeformacinfuturo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import cl.nooc.examencentrodeformacinfuturo.repository.ClientRepository
import cl.nooc.examencentrodeformacinfuturo.repository.CourseDetailsRepository
import cl.nooc.examencentrodeformacinfuturo.repository.CoursesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoursesViewModel(application: Application): AndroidViewModel(application) {

    private val clientRepo = ClientRepository()
    private val coursesRepo = CoursesRepository(getApplication())
    private val detailsRepo = CourseDetailsRepository(getApplication())

    private val log = application.getString(R.string.error_call)

    val coursesList = coursesRepo.list()
    val detailsList = detailsRepo.list()

    var id = MutableLiveData<String>()
    var courseDetail = MutableLiveData<CourseDetail>()

    fun getAllCourses(){

        if (coursesRepo.count() == 0){
            viewModelScope.launch {
                val courses = clientRepo.getCourses()
                when(courses.isSuccessful){
                    true -> courses.body()?.let { coursesRepo.add(it) }
                    else -> println(courses.message().toString())
                }
            }
        } else {
            Log.e("API", "FULL")
        }
    }

    fun getCourseDetail(id:String){
        viewModelScope.launch {
            val courseDetail = clientRepo.getCoursesDetail(id)
            when(courseDetail.isSuccessful){
                true -> courseDetail.body()?.let { detailsRepo.add(it) }
                else -> println(courseDetail.message().toString())
            }
        }
    }

    fun searchCourse(){
        CoroutineScope(Dispatchers.IO).launch {
            courseDetail.postValue(detailsRepo.search(id.value!!))
        }
    }
}