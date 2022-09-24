package cl.nooc.examencentrodeformacinfuturo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.nooc.examencentrodeformacinfuturo.dao.CourseDetailDao
import cl.nooc.examencentrodeformacinfuturo.dao.CoursesDao
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.model.CourseDetail

@Database(entities =  [Course::class, CourseDetail::class], version = 1)
abstract class CoursesDB: RoomDatabase() {

    abstract fun course(): CoursesDao
    abstract fun courseDetail(): CourseDetailDao

    companion object {
        @Volatile
        private var INSTANCE: CoursesDB? = null

        fun getDB(context: Context): CoursesDB {
            return INSTANCE ?: synchronized(this){
                val tempInstance = Room.databaseBuilder(
                    context.applicationContext,
                    CoursesDB::class.java,
                    "CoursesDataBase"
                ).build()
                INSTANCE = tempInstance
                return tempInstance
            }
        }
    }
}