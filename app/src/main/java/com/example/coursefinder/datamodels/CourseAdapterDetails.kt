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

class CourseAdapterDetails : ListAdapter<Course, CourseAdapterDetails.CourseViewHolderDetail>(
    CourseDiffCallback()
) {

    class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.courseCode == newItem.courseCode }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        } }

    class CourseViewHolderDetail(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val courseName: TextView = itemView.findViewById(R.id.textViewcourseName)
        private val instructor: TextView = itemView.findViewById(R.id.textViewinstructor)
        private val credits: TextView = itemView.findViewById(R.id.textViewcredits)
        private val courseCode: TextView = itemView.findViewById(R.id.textViewcourseCode)
        private val description: TextView = itemView.findViewById((R.id.textViewdescription))
        private val courseImageView: ImageView = itemView.findViewById(R.id.courseImageView)

        fun bind(course: Course) {
            val context = itemView.context
            courseName.text = course.courseName
            instructor.text = context.getString(R.string.instructor_label, course.instructor)
            courseCode.text = context.getString(R.string.course_code_label, course.courseCode)
            credits.text = context.getString(R.string.credits_label, course.credits)
            description.text = course.description
            courseImageView.setImageResource(imageUtil.getImageForCourse(course.courseCode))
        } }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolderDetail {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course_details, parent, false)
        return CourseViewHolderDetail(view) }

    override fun onBindViewHolder(holder: CourseViewHolderDetail, position: Int) {
        val course = getItem(position)
        holder.bind(course) }}
