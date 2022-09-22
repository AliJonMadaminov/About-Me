package com.refresh.practice.aboutme

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.refresh.practice.aboutme.databinding.ActivityMainBinding
import com.refresh.practice.aboutme.model.MyName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Alijon")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.buttonDone.setOnClickListener { view ->
            addNickname(view)

        }

    }

    fun addNickname(view: View) {
        view.visibility = View.GONE
        myName.nickName = binding.editTextNickname.text.toString()
        binding.invalidateAll()
        binding.apply {
            editTextNickname.visibility = View.GONE
            textNickname.visibility = View.VISIBLE
        }
    }
}