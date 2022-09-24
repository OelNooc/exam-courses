package cl.nooc.examencentrodeformacinfuturo.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.databinding.FragmentDetailBinding
import cl.nooc.examencentrodeformacinfuturo.viewmodel.CoursesViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel by activityViewModels<CoursesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(layoutInflater)

        viewModel.detailsList.observe(viewLifecycleOwner, Observer{
            viewModel.searchCourse()
        })

        viewModel.courseDetail.observe(viewLifecycleOwner, Observer{
            if(it!=null){
                with(binding){
                    Picasso.get().load(it.image).into(ivCourseDetail)
                    tvTitleDetail.text = it.title
                    tvDescription.text = it.description
                    tvWeeks.text = getString(R.string.weeks) + it.weeks
                    tvModality.text = it.modality
                    tvSkillLevel.text = it.minimumSkill
                    tvStart.text = it.start
                    tvCost.text = it.tuition

                    val id = it.id
                    val title = it.title
                    btnEmail.setOnClickListener {
                        val email = getString(R.string.destiny_email)
                        val intentMail = Intent(Intent.ACTION_SEND, Uri.parse(email))
                        intentMail.type = getString(R.string.mail_type)
                        intentMail.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_value)+id)
                        intentMail.putExtra(Intent.EXTRA_TEXT,
                            getString(R.string.mail_text1)+title+getString(R.string.mail_text2))
                        startActivity(Intent.createChooser(intentMail, getString(R.string.ask_pref_app)))
                    }
                }
            }
        })

       /* with(binding){
            btnEmail.setOnClickListener {
                val email = getString(R.string.destiny_email)
                val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
                intentEmail.type = getString(R.string.mail_type)
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_value)+)
            }
        }*/

        return binding.root
    }
}