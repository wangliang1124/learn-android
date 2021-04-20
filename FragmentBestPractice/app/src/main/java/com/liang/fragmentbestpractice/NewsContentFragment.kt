package com.liang.fragmentbestpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class NewsContentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_content_frag, container, false)
    }

    fun refresh(title: String, content: String){
        val contentLayout: ConstraintLayout? = activity?.findViewById(R.id.contentLayout)
        contentLayout?.visibility = View.VISIBLE

        val newsTitle: TextView? = activity?.findViewById(R.id.newsTitle)
        newsTitle?.text = title

        val newsContent: TextView? = activity?.findViewById(R.id.newsContent)
        newsContent?.text = content

    }
}