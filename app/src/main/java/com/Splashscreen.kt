package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.pizza_delivery.R

class Splashscreen : AppCompatActivity() {
    private lateinit var text : TextView
    private lateinit var logo : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)
        text=findViewById(R.id.textView)
        logo=findViewById(R.id.imageView)
        text.textSize = 35F
        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val stb=AnimationUtils.loadAnimation(this,R.anim.stb)
        text.startAnimation(ttb)
        logo.startAnimation(stb)
        val intent = Intent(this, HomeScreen::class.java)
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(intent)
            }
        }
        timer.start()

    }
}