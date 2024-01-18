package com.dicoding.mysimplelogin.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.mysimplelogin.chat.databinding.ActivityChatBinding
import com.example.core.SessionManager
import com.example.core.UserRepository

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvChat= binding.tvChat
        val sesi=SessionManager(this)
        val userRepository= UserRepository.getInstance(sesi)
        tvChat.text="Welcome ${userRepository.getUser()} to Chat Feature"


    }
}