package com.example.mysimplecleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mysimplecleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //setting viewModelfactory
        val factory = MainViewModelFactory.getInstace()
        //setting viewModel
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]


        //set nama
        viewModel.setName("Rama")

        //observe
        viewModel.message.observe(this) {
            binding.tvWelcome.text = it.welcomeMessage
        }

    }
}