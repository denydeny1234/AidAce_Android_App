
package com.example.aidace

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CaloriesActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories2)



        val button = findViewById<ImageView>(R.id.imageView4)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val result = findViewById<TextView>(R.id.textView2)

        //making the BMI calculator
        button.setOnClickListener {
            val h = height.text.toString()
                .toFloat() / 100 //we will get the height value and convert it in meters
            val w = weight.text.toString()
                .toFloat() // we will get the weight value and convert it into float
            val res = w / (h * h) // formula for the BMI
            result.text = "%2f".format(res) // format the result to display only two decimals
        }

        val buttonClick = findViewById<ImageView>(R.id.imageView)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

//Play sound
//        val buttonSound = findViewById<ImageView>(R.id.imageView4)

    }



}





