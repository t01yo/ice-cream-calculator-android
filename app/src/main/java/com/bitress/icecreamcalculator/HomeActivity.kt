package com.bitress.icecreamcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private lateinit var placeOrderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val mangoFlavourButton = findViewById<Button>(R.id.mangoButton)
        val mintFlavourButton = findViewById<Button>(R.id.mintButton)
        val vanillaFlavourButton = findViewById<Button>(R.id.vanillaButton)

        val mangoIndicator = findViewById<View>(R.id.mangoIndicator)
        val mintIndicator = findViewById<View>(R.id.mintIndicator)
        val vanillaIndicator = findViewById<View>(R.id.vanillaIndicator)


        val flavours = listOf(mangoFlavourButton, mintFlavourButton, vanillaFlavourButton)
        val indicators = listOf(mangoIndicator, mintIndicator, vanillaIndicator)

        var selectedFlavour = ""
        val selectedSize = ""

        for ((index, flavour) in flavours.withIndex()) {
            flavour.setOnClickListener {
                for (indicator in indicators) {
                    indicator.visibility = View.GONE
                }
                indicators[index].visibility = View.VISIBLE
                for (btn in flavours) {
                    btn.isSelected = false
                }
                it.isSelected = true
                selectedFlavour = (it as Button).text.toString()
            }
        }


        placeOrderButton = findViewById(R.id.placeOrderButton)

        placeOrderButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("flavour", selectedFlavour)

            startActivity(intent)
        }

    }
}