package cl.nooc.examencentrodeformacinfuturo

import java.io.File
import java.io.InputStreamReader

object Reader {

    fun jsonReader(file:String): String{
        val input = File("src/main/assets/$file").inputStream()
        val builder = StringBuilder()
        val reader = InputStreamReader(input, "UTF-8")

        reader.readLines().forEach{
            builder.append(it)
        }
        return builder.toString()
    }
}