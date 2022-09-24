package cl.nooc.examencentrodeformacinfuturo.service

import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoursesService {

    @GET("courses/")
    suspend fun getCourses(): Response<ArrayList<Course>>

    @GET("courses_details/{id}/")
    suspend fun getCourseDetail(@Path("id") id: String): Response<CourseDetail>
}