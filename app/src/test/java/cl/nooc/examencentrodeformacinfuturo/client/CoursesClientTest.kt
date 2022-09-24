package cl.nooc.examencentrodeformacinfuturo.client

import cl.nooc.examencentrodeformacinfuturo.Reader
import com.google.common.truth.Truth
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class CoursesClientTest {

    private val server = MockWebServer()
    private val body = Reader.jsonReader("course.json")

    @Before
    fun setUp(){
        server.start(8080)
        server.enqueue(MockResponse().setResponseCode(200).setBody(body))
        server.url("courses_details/100/")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun test_apiSucces(){

        //given
        val call = CoursesClient.retrofitInstanceCustomUrl("http://localhost:8080/").getCourseDetail("100")
        //when
        val course = call.execute().body()
        //then
        Truth.assertThat(course?.title).isEqualTo("Front End Web Development")
    }
}