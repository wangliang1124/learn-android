package com.liang.uiwidgetdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editText1: EditText
    private lateinit var progressBar1: ProgressBar
    private lateinit var progressBar2: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        editText1 = findViewById(R.id.editText1)
        progressBar1 = findViewById(R.id.progressBar1)
        progressBar2 = findViewById(R.id.progressBar2)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
//                val inputText = editText1.text.toString()
//                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();

//                if (progressBar1.visibility == View.VISIBLE) {
//                    progressBar1.visibility = View.GONE
//                } else {
//                    progressBar1.visibility = View.VISIBLE
//                }

                progressBar2.progress = progressBar2.progress + 10
            }
            R.id.button2 -> {
                AlertDialog.Builder(this).apply {
                    setTitle("This is a Dialog")
                    setMessage("Message Message Message")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->
                        Log.d(TAG, "onClick: $dialog $which")
                    }
                    setNegativeButton("Cancel") { dialog, which ->
                        Log.d(TAG, "onClick: $dialog $which")
                    }
                    show()
                }
            }
            R.id.button3 -> {
                val intent = Intent(this, RelativeLayoutDemo::class.java)
                startActivity(intent)
            }
        }
    }
}