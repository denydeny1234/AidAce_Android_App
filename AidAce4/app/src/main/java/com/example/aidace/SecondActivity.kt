package com.example.aidace

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        val buttonClick = findViewById<ImageView>(R.id.imageView11)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        val buttonToSettings = findViewById<ImageView>(R.id.imageView20)
        buttonToSettings.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        val buttonClickCalories = findViewById<ImageView>(R.id.imageView10)
        buttonClickCalories.setOnClickListener {
            val intent = Intent(this, CaloriesActivity::class.java)
            startActivity(intent)

        }
    }
}