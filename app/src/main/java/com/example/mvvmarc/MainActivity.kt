package com.example.mvvmarc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.mvvmarc.Adapter.recyclerViewAdapter
import com.example.mvvmarc.ViewModel.UserViewModel
import com.example.mvvmarc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = recyclerViewAdapter()
        binding.recView.adapter = adapter
        //observe livedata
        userViewModel.response.observe(this@MainActivity, Observer { response ->
            response?.let {
                adapter.submitList(it.data)
            }

        })

        //fetch the user
        userViewModel.fetchUser()
    }
}