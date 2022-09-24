package cl.nooc.examencentrodeformacinfuturo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import cl.nooc.examencentrodeformacinfuturo.repository.ClientRepository
import cl.nooc.examencentrodeformacinfuturo.repository.CourseDetailsRepository
import cl.nooc.examencentrodeformacinfuturo.repository.CoursesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            clientRepo.getCourses().enqueue(object: Callback<ArrayList<Course>>{
                override fun onResponse(
                    call: Call<ArrayList<Course>>,
                    response: Response<ArrayList<Course>>
                ) {
                    response.body().let { coursesRepo.add(it!!) }
                }

                override fun onFailure(call: Call<ArrayList<Course>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        } else {
            Log.e("API", "FULL")
        }
    }

    fun getCourseDetail(id:String){
        clientRepo.getCoursesDetail(id).enqueue(object: Callback<CourseDetail>{
            override fun onResponse(call: Call<CourseDetail>, response: Response<CourseDetail>) {
                response.body().let { detailsRepo.add(it!!) }
            }

            override fun onFailure(call: Call<CourseDetail>, t: Throwable) {
                Log.e(log,t.message.toString())
            }
        })
    }

    fun searchCourse(){
        CoroutineScope(Dispatchers.IO).launch {
            courseDetail.postValue(detailsRepo.search(id.value!!))
        }
    }
}