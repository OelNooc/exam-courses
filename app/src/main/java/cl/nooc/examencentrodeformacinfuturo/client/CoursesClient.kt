package cl.nooc.examencentrodeformacinfuturo.client

import cl.nooc.examencentrodeformacinfuturo.service.CoursesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoursesClient {

    companion object {
        private const val  BASE_URL = "https://courses-fake-api.herokuapp.com/"

        fun retrofitInstance(): CoursesService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CoursesService::class.java)
        }

        fun retrofitInstanceCustomUrl(url:String): CoursesService {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CoursesService::class.java)
        }
    }
}