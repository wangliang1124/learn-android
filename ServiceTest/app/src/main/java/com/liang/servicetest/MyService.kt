package com.liang.servicetest

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "MyService"

class MyService : LifecycleService() {
    private val mBinder = DownloadBinder()
    private var number = 0
    val numberLiveData = MutableLiveData(0)

    inner  class DownloadBinder : Binder() {
//        val service: MyService = this@MyService
        fun startDownload() {
            Log.d(TAG, "startDownload: executed")
        }

        fun getProgress(): MutableLiveData<Int> {
            Log.d(TAG, "getProgress: executed")
            return numberLiveData;
//            return 0
        }

        fun getNumber():MutableLiveData<Int>{
            return numberLiveData
        }
    }

    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        lifecycleScope.launch {
            while (true) {
                delay(1000)
                numberLiveData.value = numberLiveData.value?.plus(1)
            }
        }
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: executed")

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "my_service",
                "前台 Service 通知",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0)

        val notification = NotificationCompat.Builder(this, "my_service")
            .setContentTitle("This is content title")
            .setContentText("This is content text")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.dog))
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: executed")
        lifecycleScope.launch {
            while (true) {
                delay(1000)
                Log.d(TAG, "onStartCommand: ${number++}")
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSelf();
        Log.d(TAG, "onDestroy: executed")
    }


}