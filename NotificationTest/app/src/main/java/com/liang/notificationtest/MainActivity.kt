package com.liang.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var channel = NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)

            var channel2 = NotificationChannel("important", "Important", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
        manager.cancel(1)

        val sendNotice: Button = findViewById(R.id.sendNotice)
        val sendNotice2: Button = findViewById(R.id.sendNotice2)

        sendNotice.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "normal")
                    .setContentTitle("This is content title")
                    .setContentText("This is content text")
                    .setSmallIcon(R.drawable.noti_dog)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.dog))
                    .setContentIntent(pi)
                    .build()
            manager.notify(1, notification)
        }

        sendNotice2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
//                .setContentText("long long text long long text long long text long long text long long text long long text long long text long long text")
                .setStyle(NotificationCompat.BigTextStyle().bigText("long long text long long text long long text long long text long long text long long text long long text long long text"))
                .setSmallIcon(R.drawable.noti_dog)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.dog))
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.dog)))
                .setContentIntent(pi)
                .build()
            manager.notify(1, notification)
        }
    }
}