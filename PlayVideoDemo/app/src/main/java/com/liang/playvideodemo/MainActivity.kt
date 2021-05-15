package com.liang.playvideodemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.mov_bbb}")
        videoView.setVideoURI(uri)

        findViewById<Button>(R.id.play).setOnClickListener{
            if(!videoView.isPlaying){
                videoView.start()
            }
        }

        findViewById<Button>(R.id.pause).setOnClickListener{
            if(videoView.isPlaying){
                videoView.pause()
            }
        }

        findViewById<Button>(R.id.replay).setOnClickListener{
            if(videoView.isPlaying){
                videoView.resume()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}