package com.example.coursefinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import com.example.coursefinder.databinding.ActivityDetailsBinding
import com.example.coursefinder.datamodels.CourseAdapterDetails
import com.example.coursefinder.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsViewModels: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recyclerView
        binding.recyclerViewCourseDetails.layoutManager = LinearLayoutManager(this)
        val adapter = CourseAdapterDetails()
        binding.recyclerViewCourseDetails.adapter = adapter

       detailsViewModels.courses.observe(this) { courses ->
            courses?.let {
                adapter.submitList(it) } }

        //  Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard -> {
                    // Go to Dashboard
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.details -> {
                    // Maintains Details page/ Refresh
                    val intent = Intent(this, DetailsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.logout -> {
                    // Go to Login page
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Set Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar) } }