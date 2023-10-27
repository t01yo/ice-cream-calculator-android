package com.bitress.icecreamcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private lateinit var placeOrderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        placeOrderButton.setOnClickListener {
            val intents = Intent(this, SecondActivity::class.java)
            startActivity(intents)
        }

    }
}