package cl.nooc.examencentrodeformacinfuturo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.databinding.ActivityMainBinding
import cl.nooc.examencentrodeformacinfuturo.viewmodel.CoursesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CoursesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllCourses()
    }
}