package cl.nooc.examencentrodeformacinfuturo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.adapter.CoursesAdapter
import cl.nooc.examencentrodeformacinfuturo.databinding.FragmentListBinding
import cl.nooc.examencentrodeformacinfuturo.model.Course
import cl.nooc.examencentrodeformacinfuturo.viewmodel.CoursesViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel by activityViewModels<CoursesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)

        val adapter = CoursesAdapter()
        adapter.setCustomOnClickListener(object: CoursesAdapter.CustomOnClickListener{
            override fun onClickListener(course: Course) {
                viewModel.getCourseDetail(course.id)
                viewModel.id.value = course.id

                Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_detailFragment)
            }
        })

        binding.rvCourses.adapter = adapter

        viewModel.coursesList.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
        return binding.root
    }

}