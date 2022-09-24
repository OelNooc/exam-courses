package cl.nooc.examencentrodeformacinfuturo.room

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cl.nooc.examencentrodeformacinfuturo.dao.CourseDetailDao
import cl.nooc.examencentrodeformacinfuturo.getOrAwaitValue
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CourseDBTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private lateinit var db: CoursesDB
    private lateinit var dao: CourseDetailDao

    @Before
    fun setUp(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CoursesDB::class.java).allowMainThreadQueries().build()
        dao = db.courseDetail()
    }

    @After
    fun tearDown(){
        db.close()
    }

    @Test
    fun addCourseTest(){
        var courseDetail = CourseDetail("This course will provide you with all of the essentials to become a successful frontend web developer. You will learn to master HTML, CSS and front end JavaScript, along with tools like Git, VSCode and front endframeworks like Vue",
        "100", "https://user-images.githubusercontent.com/22780253/120053848-84763280-bffa-11eb-9d4c-a8f923e55d75.jpg",
        "beginner", "bootcamp", true, "november 2021",
        "Front End Web Development", "$800.000", 8)

        dao.addDetails(courseDetail)
        var response = dao.search("100")
        Truth.assertThat(response).isEqualTo(courseDetail)
    }

    @Test
    fun listCourseTest(){
        var courseDetail = CourseDetail("This course will provide you with all of the essentials to become a successful frontend web developer. You will learn to master HTML, CSS and front end JavaScript, along with tools like Git, VSCode and front endframeworks like Vue",
            "100", "https://user-images.githubusercontent.com/22780253/120053848-84763280-bffa-11eb-9d4c-a8f923e55d75.jpg",
            "beginner", "bootcamp", true, "november 2021",
            "Front End Web Development", "$800.000", 8)

        dao.addDetails(courseDetail)
        val list = dao.listDetails().getOrAwaitValue()
        Truth.assertThat(list[0].id).isEqualTo("100")
    }
}