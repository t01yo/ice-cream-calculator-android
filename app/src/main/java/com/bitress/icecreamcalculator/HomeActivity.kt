package com.bitress.icecreamcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private var quantity = 1
    private lateinit var quantityTextView: TextView
    private lateinit var placeOrderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val minusButton: Button = findViewById(R.id.minus)
        val plusButton: Button = findViewById(R.id.plus)
        quantityTextView = findViewById(R.id.quantityTextView)

        quantityTextView.text = quantity.toString()

        minusButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantity()
            }
        }

        plusButton.setOnClickListener {
            quantity++
            updateQuantity()
        }


        val mangoFlavourButton = findViewById<Button>(R.id.mangoButton)
        val mintFlavourButton = findViewById<Button>(R.id.mintButton)
        val vanillaFlavourButton = findViewById<Button>(R.id.vanillaButton)


        val mangoIndicator = findViewById<View>(R.id.mangoIndicator)
        val mintIndicator = findViewById<View>(R.id.mintIndicator)
        val vanillaIndicator = findViewById<View>(R.id.vanillaIndicator)

        val smallSizeButton = findViewById<Button>(R.id.smallButton)
        val mediumSizeButton = findViewById<Button>(R.id.mediumButton)
        val largeSizeButton = findViewById<Button>(R.id.largeButton)

        val smallIndicator = findViewById<View>(R.id.smallIndicator)
        val mediumIndicator = findViewById<View>(R.id.mediumIndicator)
        val largeIndicator = findViewById<View>(R.id.largeIndicator)


        val baconCheckbox = findViewById<CheckBox>(R.id.baconCheckbox)
        val blueberryCheckbox = findViewById<CheckBox>(R.id.blueberryCheckbox)
        val cheeseCheckbox = findViewById<CheckBox>(R.id.cheeseCheckbox)
        val cherryCheckbox = findViewById<CheckBox>(R.id.cherryCheckbox)
        val mangoChunksCheckbox = findViewById<CheckBox>(R.id.mangoChunksCheckbox)
        val marshmallowCheckbox = findViewById<CheckBox>(R.id.marshmallowCheckbox)

        val flavours = listOf(mangoFlavourButton, mintFlavourButton, vanillaFlavourButton)
        val flavourIndicator = listOf(mangoIndicator, mintIndicator, vanillaIndicator)

        val sizes = listOf(smallSizeButton, mediumSizeButton, largeSizeButton)
        val sizeIndicator = listOf(smallIndicator, mediumIndicator, largeIndicator)

        placeOrderButton = findViewById(R.id.placeOrderButton)


        var selectedFlavour = ""
        var selectedSize = ""
        val selectedToppings = mutableListOf<String>()

        for ((index, flavour) in flavours.withIndex()) {
            flavour.setOnClickListener {
                for (indicator in flavourIndicator) {
                    indicator.visibility = View.GONE
                }
                flavourIndicator[index].visibility = View.VISIBLE
                for (btn in flavours) {
                    btn.isSelected = false
                }
                it.isSelected = true
                selectedFlavour = (it as Button).text.toString()
            }
        }

        for ((index, size) in sizes.withIndex()) {
            size.setOnClickListener {
                for (indicator in sizeIndicator) {
                    indicator.visibility = View.GONE
                }
                sizeIndicator[index].visibility = View.VISIBLE
                for (btn in sizes) {
                    btn.isSelected = false
                }
                it.isSelected = true
                selectedSize = (it as Button).text.toString()
            }
        }



        placeOrderButton.setOnClickListener {

            var totalPrice = 0


            if (baconCheckbox.isChecked) {
                selectedToppings.add(baconCheckbox.text.toString())
                totalPrice += 40
            }

            if (blueberryCheckbox.isChecked) {
                selectedToppings.add(blueberryCheckbox.text.toString())
                totalPrice += 40
            }

            if (cheeseCheckbox.isChecked) {
                selectedToppings.add(cheeseCheckbox.text.toString())
                totalPrice += 20
            }

            if (cherryCheckbox.isChecked) {
                selectedToppings.add(cherryCheckbox.text.toString())
                totalPrice += 40
            }

            if (mangoChunksCheckbox.isChecked) {
                selectedToppings.add(mangoChunksCheckbox.text.toString())
                totalPrice += 30
            }

            if (marshmallowCheckbox.isChecked) {
                selectedToppings.add(marshmallowCheckbox.text.toString())
                totalPrice += 20
            }

            val sizePrice = when (selectedSize) {
                "Small" -> 50
                "Medium" -> 80
                "Large" -> 120
                else -> 0
            }

            totalPrice += sizePrice

            val finalPrice = quantity * totalPrice

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("flavour", selectedFlavour)
            intent.putExtra("size", selectedSize)
            intent.putStringArrayListExtra("toppings", ArrayList(selectedToppings))
            intent.putExtra("total_price", finalPrice)
            startActivity(intent)
        }

    }

    private fun updateQuantity() {
        quantityTextView.text = quantity.toString()
    }
}