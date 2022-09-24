package cl.nooc.examencentrodeformacinfuturo.repository

import cl.nooc.examencentrodeformacinfuturo.client.CoursesClient
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import retrofit2.Call
import retrofit2.Response

class ClientRepository {

    private val client = CoursesClient.retrofitInstance()

    fun getCourses(): Call<ArrayList<Course>>{
        return client.getCourses()
    }

    fun getCoursesDetail(id: String): Call<CourseDetail>{
        return client.getCourseDetail(id)
    }
}