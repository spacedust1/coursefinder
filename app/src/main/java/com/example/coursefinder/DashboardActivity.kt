package com.example.coursefinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursefinder.databinding.ActivityDashboardBinding
import com.example.coursefinder.viewmodel.DashboardViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import com.example.coursefinder.datamodels.CourseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  RecyclerView
        binding.recyclerViewCourses.layoutManager = LinearLayoutManager(this)
        val adapter = CourseAdapter()
        binding.recyclerViewCourses.adapter = adapter

        dashboardViewModel.courses.observe(this) { courses ->
            courses?.let {
                adapter.submitList(it) // Update the adapter
            }
        }

        // Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard -> {
                    // Stays Dashboard/Refresh
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    true }
                R.id.details -> {
                    // Go to Details page
                    val intent = Intent(this, DetailsActivity::class.java)
                    startActivity(intent)
                    true }
                R.id.logout -> {
                    // Go to Login page
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true }
                else -> false
            }}}}