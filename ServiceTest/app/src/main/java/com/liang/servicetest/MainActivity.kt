package com.liang.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {


    lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            (service as MyService.DownloadBinder).service.numberLiveData.observe(
                this@MainActivity,
                Observer {
                    findViewById<TextView>(R.id.textView).text = "$it"
                })
//            downloadBinder.startDownload()
//            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startServiceBtn).setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
            }
        }

        findViewById<Button>(R.id.stopServiceBtn).setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
            }
        }

        findViewById<Button>(R.id.bindServiceBtn).setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                bindService(it, connection, Context.BIND_AUTO_CREATE)
            }
        }

        findViewById<Button>(R.id.unbindServiceBtn).setOnClickListener {
            Intent(this, MyService::class.java).also {
                unbindService(connection)
            }
        }

        findViewById<Button>(R.id.gotoSecondBtn).setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}