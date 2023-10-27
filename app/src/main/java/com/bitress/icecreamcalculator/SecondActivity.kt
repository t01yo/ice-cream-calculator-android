package com.bitress.icecreamcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private  lateinit var returnHomeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val flavourImage = findViewById<ImageView>(R.id.flavourImage)
        val flavorTextView = findViewById<TextView>(R.id.flavorTextView)
        val toppingsTextView = findViewById<TextView>(R.id.toppingsTextView)
        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)
        val sizeTextView = findViewById<TextView>(R.id.sizeTextView)


        returnHomeButton = findViewById(R.id.returnHomeButton)

        val flavor = intent.getStringExtra("flavour")
        val toppings = intent.getStringArrayListExtra("toppings")
        val totalPrice = intent.getIntExtra("total_price", 0)
        val size = intent.getStringExtra("size")

        when (flavor) {
            "Mango" -> flavourImage.setImageResource(R.drawable.mango)
            "Mint" ->  flavourImage.setImageResource(R.drawable.mint)
            "Vanilla" ->  flavourImage.setImageResource(R.drawable.vanilla)
            else -> {
                flavourImage.setImageResource(R.drawable.logo)
            }
        }




        flavorTextView.text = "Flavor: $flavor"
        sizeTextView.text = "Size: $size"
        toppingsTextView.text = "Toppings: ${toppings?.joinToString(", ")}"
        totalPriceTextView.text = "Total Price: $totalPrice"

        // Intent Return to Home Activity
        returnHomeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}