package cl.nooc.examencentrodeformacinfuturo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.databinding.FragmentDetailBinding
import cl.nooc.examencentrodeformacinfuturo.viewmodel.CoursesViewModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<CoursesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }
}