package com.example.myleakyapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myleakyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityMainBinding


    private lateinit var broadcastReceiver:BroadcastReceiver
    private lateinit var tvPowerStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvPowerStatus = binding.tvPowerStatus

    }


    private fun registerBroadcastReceiver(){
        broadcastReceiver=object :BroadcastReceiver(){
            override fun onReceive(context: Context, intent: Intent) {
                when(intent.action){
                    Intent.ACTION_POWER_CONNECTED->{
                        tvPowerStatus.text=getString(R.string.power_connected)
                    }
                    Intent.ACTION_POWER_DISCONNECTED->{
                        tvPowerStatus.text=getString(R.string.power_disconnected)
                    }
                }
            }
        }

        val intentFilter= IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)

        }
        registerReceiver(broadcastReceiver,intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadcastReceiver()
    }

//    //    Fix : unregister in onStop
//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(broadcastReceiver)
//    }
}