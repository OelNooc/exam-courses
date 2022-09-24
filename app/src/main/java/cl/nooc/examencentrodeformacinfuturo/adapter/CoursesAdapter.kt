package cl.nooc.examencentrodeformacinfuturo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.nooc.examencentrodeformacinfuturo.R
import cl.nooc.examencentrodeformacinfuturo.databinding.ItemLayoutBinding
import cl.nooc.examencentrodeformacinfuturo.model.Course
import com.squareup.picasso.Picasso

class CoursesAdapter: RecyclerView.Adapter<CoursesAdapter.CustomViewHolder>() {

    private var list: List<Course> = ArrayList()
    lateinit var listener: CustomOnClickListener

    class CustomViewHolder(itemView: View, var listener: CustomOnClickListener): RecyclerView.ViewHolder(itemView){
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(course:Course){
            with(binding){
                Picasso.get().load(course.image).resize(250,250).into(ivCourse)
                tvCourseName.text = course.title
                tvSkillLevel.text = course.previewDescription
                itemView.setOnClickListener {
                    listener.onClickListener(course)
                }
            }
        }
    }

    interface CustomOnClickListener{
        fun onClickListener(course: Course)
    }

    fun setCustomOnClickListener(listener: CustomOnClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(list:List<Course>){
        this.list = list
        notifyDataSetChanged()
    }
}