package com.example.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.example.databinding.ActivityBirthdayBinding

class BirthdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBirthdayBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}