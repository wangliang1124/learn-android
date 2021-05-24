package com.liang.viewmodeltest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var factory:ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.textView1)


        factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        myViewModel = ViewModelProvider(this,factory).get(MyViewModel::class.java)

        textView1.text = myViewModel.number.toString()

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            myViewModel.number++
            textView1.text = myViewModel.number.toString();
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            myViewModel.number--
            textView1.text = myViewModel.number.toString();
        }

    }
}