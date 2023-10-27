package com.bitress.icecreamcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private  lateinit var returnHomeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val flavorTextView = findViewById<TextView>(R.id.flavorTextView)

        returnHomeButton = findViewById(R.id.returnHomeButton)



        val flavor = intent.getStringExtra("flavour")
        flavorTextView.text = "Flavor: $flavor"

        // Intent Return to Home Activity
        returnHomeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}