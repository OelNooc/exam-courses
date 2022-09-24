package cl.nooc.examencentrodeformacinfuturo.repository

import cl.nooc.examencentrodeformacinfuturo.client.CoursesClient
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import retrofit2.Response

class ClientRepository {

    private val client = CoursesClient.retrofitInstance()

   suspend fun getCourses(): Response<ArrayList<Course>>{
        return client.getCourses()
    }

    suspend fun getCoursesDetail(id: String): Response<CourseDetail>{
        return client.getCourseDetail(id)
    }
}