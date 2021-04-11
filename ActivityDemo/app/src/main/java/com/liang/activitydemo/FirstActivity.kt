package com.liang.activitydemo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    private val TAG = "FirstActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", this.toString())

        Log.d(TAG, "onCreate: task id is $taskId")

        setContentView(R.layout.first_layout)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val buttonLaunchMode: Button  = findViewById(R.id.button4)

        button1.setOnClickListener {
//            Toast.makeText(this, "button clicked!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            val data = "Hello Second"
            intent.putExtra("extra_data", data)

//            val intent = Intent("com.liang.activitydemo.ACTION_START")
//            intent.addCategory("com.liang.activitydemo.MY_CATEGORY")

//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")

//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel: 10086")
            startActivityForResult(intent, 0)
        }

        button2.setOnClickListener {
            finish()
        }

        buttonLaunchMode.setOnClickListener{
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "clicked add item", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "clicked remove item", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            0 -> if(resultCode == Activity.RESULT_OK) {
                val resultData = data?.getStringExtra("data_return")
                Log.d(TAG, "onActivityResult: $resultData")
            }
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: FirstActivity")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
    }
}