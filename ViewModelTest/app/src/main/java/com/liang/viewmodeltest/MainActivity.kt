package com.liang.viewmodeltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.liang.viewmodeltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val textView1 = findViewById<TextView>(R.id.textView1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)

        binding.data = myViewModel
        binding.lifecycleOwner = this

//        myViewModel.getNumber().observe(this, Observer {
//            binding.textView1.text = it.toString()
//        })
//
//
//        binding.btnPlus.setOnClickListener {
//            myViewModel.addNumber()
//        }
//
//        binding.btnMinus.setOnClickListener {
//           myViewModel.minusNumber()
//        }

    }
}