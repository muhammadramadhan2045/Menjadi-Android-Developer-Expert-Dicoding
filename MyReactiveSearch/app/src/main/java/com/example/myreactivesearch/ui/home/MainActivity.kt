package com.example.myreactivesearch.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myreactivesearch.R
import com.example.myreactivesearch.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edPlace=binding.edPlace

        edPlace.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                lifecycleScope.launch {
                    viewModel.queryChannel.value=s.toString()
                }
            }

        })

        viewModel.searchResult.observe(this, Observer { placesItem->
            val placesName=placesItem.map{
                it.placeName
            }
            val adapter=ArrayAdapter(this@MainActivity,android.R.layout.select_dialog_item,placesName)
            adapter.notifyDataSetChanged()
            edPlace.setAdapter(adapter)

        })
    }
}