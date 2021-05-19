package com.liang.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Intent(this, MyService::class.java).also {
            val connection = object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    (service as MyService.DownloadBinder).getNumber().observe(this@SecondActivity,
                        Observer {
                            findViewById<TextView>(R.id.textView2).text = "$it"
                        })
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    TODO("Not yet implemented")
                }

            }

            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
    }
}