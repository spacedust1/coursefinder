package com.example.coursefinder.datamodels

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coursefinder.DetailsActivity
import com.example.coursefinder.R
import com.example.coursefinder.ui.theme.imageUtil

class CourseAdapter : ListAdapter<Course, CourseAdapter.CourseViewHolderDashboard>(
    CourseDiffCallback()
) {

    class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.courseCode == newItem.courseCode }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        } }

    class CourseViewHolderDashboard(itemView: View) : RecyclerView.ViewHolder(itemView) { //Dashboard
        private val courseName: TextView = itemView.findViewById(R.id.textViewcourseName)
        private val instructor: TextView = itemView.findViewById(R.id.textViewinstructor)
        private val credits: TextView = itemView.findViewById(R.id.textViewcredits)
        private val courseCode: TextView = itemView.findViewById(R.id.textViewcourseCode)
        private val courseImageView: ImageView = itemView.findViewById(R.id.courseImageView)



        fun bind(course: Course) {
            val context = itemView.context
            courseName.text = course.courseName
            instructor.text = context.getString(R.string.instructor_label, course.instructor)
            courseCode.text = context.getString(R.string.course_code_label, course.courseCode)
            credits.text = context.getString(R.string.credits_label, course.credits)

            courseImageView.setImageResource(imageUtil.getImageForCourse(course.courseCode))


            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("course", course)
                context.startActivity(intent)
            } } }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolderDashboard {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolderDashboard(view)
    }
    override fun onBindViewHolder(holder: CourseViewHolderDashboard, position: Int) {
        val course = getItem(position)
        holder.bind(course)
    } }
