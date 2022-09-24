package cl.nooc.examencentrodeformacinfuturo.service

import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoursesService {

    @GET("courses/")
    fun getCourses(): Call<ArrayList<Course>>

    @GET("courses_details/{id}/")
    fun getCourseDetail(@Path("id") id: String): Call<CourseDetail>
}