package com.example.aidace

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var increaseButton: Button
    private lateinit var decreaseButton: Button
    private lateinit var increaseAdjustButton: Button
    private lateinit var decreaseAdjustButton: Button
    private lateinit var valueTextView: TextView
    private lateinit var currentValueTextView: TextView
    private var incrementValue = 25
    private var decrementValue = 25
    private var value = 100
    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun vibrate(){
            val vib = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager =
                    getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE) )
            }else{
                @Suppress("DEPRECATION")
                vib.vibrate(300)
            }
        }


        mediaPlayer = MediaPlayer.create(this, R.raw.hmm)

            val buttonClick = findViewById<ImageView>(R.id.waterBack)
            buttonClick.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

            increaseButton = findViewById(R.id.btn_add_ml)
            decreaseButton = findViewById(R.id.btn_remove_ml)
            increaseAdjustButton = findViewById(R.id.btnadjusmlplus)
            decreaseAdjustButton = findViewById(R.id.btnadjustmlminus)
            valueTextView = findViewById(R.id.watertextml)
            currentValueTextView = findViewById(R.id.watercurrentadjustment)
            currentValueTextView.text = "Current Value: $value"


            increaseButton.setOnClickListener {
                mediaPlayer.start()
                vibrate()
                val currentValue = currentValueTextView.text.toString().substringAfter(": ").toInt()
                val newValue = value + currentValue
                if (newValue >= 0) {
                    value = newValue
                }
                valueTextView.text = "$value ml"
            }

            decreaseButton.setOnClickListener {
                vibrate()
                val currentValue = currentValueTextView.text.toString().substringAfter(": ").toInt()
                val newValue = value - currentValue
                if (newValue >= 0) {
                    value = newValue
                }
                valueTextView.text = "$value ml"
            }

            increaseAdjustButton.setOnClickListener {
                vibrate()
                val currentValue = currentValueTextView.text.toString().substringAfter(": ").toInt()
                val newValue = currentValue + 25
                if (newValue >= 0) {
                    currentValueTextView.text = "Current Value: $newValue"
                } else {
                    currentValueTextView.text = "Current Value: 0"
                }
            }

            decreaseAdjustButton.setOnClickListener {
                vibrate()
                val currentValue = currentValueTextView.text.toString().substringAfter(": ").toInt()
                val newValue = currentValue - 25
                if (newValue >= 0) {
                    currentValueTextView.text = "Current Value: $newValue"
                } else {
                    currentValueTextView.text = "Current Value: 0"
                }

            }
        }
    }

