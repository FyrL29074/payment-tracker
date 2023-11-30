package com.fyrl29074.payment_tracker.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fyrl29074.payment_tracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}