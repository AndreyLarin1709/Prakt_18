package com.example.pr18

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var time = object : CountDownTimer(2300, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }
        }
        time.start()
    }
}