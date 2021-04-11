package com.liang.activitydemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "onCreate: Task id is $taskId")

        val extraData = intent.getStringExtra("extra_data")
        Log.d(TAG, "extra data is $extraData")

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            val intent = Intent()
            intent.putExtra("data_return", "Hello First")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        findViewById<Button>(R.id.button5).setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent: Task id is $taskId")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: SecondActivity")
    }
}