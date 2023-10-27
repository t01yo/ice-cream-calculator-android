package com.bitress.icecreamcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var myButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        calculateButton.setOnClickListener {

            val selectedToppings = mutableListOf<String>()
            val selectedFlavourId = flavourRadioGroup.checkedRadioButtonId
            val selectedSizeId = sizeRadioGroup.checkedRadioButtonId

            var totalPrice = 0

            if (mangoChunksCheckbox.isChecked) {
                selectedToppings.add(mangoChunksCheckbox.text.toString())
                totalPrice += 30
            }
            if (marshmallowCheckbox.isChecked) {
                selectedToppings.add(marshmallowCheckbox.text.toString())
                totalPrice += 20
            }
            if (cherryCheckbox.isChecked) {
                selectedToppings.add(cherryCheckbox.text.toString())
                totalPrice += 40
            }
            if (cheeseCheckbox.isChecked) {
                selectedToppings.add(cheeseCheckbox.text.toString())
                totalPrice += 20
            }
            if (blueberryCheckbox.isChecked) {
                selectedToppings.add(blueberryCheckbox.text.toString())
                totalPrice += 40
            }
            if (baconCheckbox.isChecked) {
                selectedToppings.add(baconCheckbox.text.toString())
                totalPrice += 40
            }

            if (selectedFlavourId != -1) {



                val intent = Intent(this, SecondActivity::class.java)

                // Get the selected flavour radio button
                val selectedFlavourRadioButton = findViewById<RadioButton>(selectedFlavourId)
                // Get the selected size radio button
                val selectedSizeRadioButton = findViewById<RadioButton>(selectedSizeId)

                val selectedFlavourText = selectedFlavourRadioButton.text.toString()
                val selectedSizeText = selectedSizeRadioButton.text.toString()

                intent.putExtra("flavour", selectedFlavourText)
                intent.putExtra("size", selectedSizeText)
                intent.putStringArrayListExtra("toppings", ArrayList(selectedToppings))
                intent.putExtra("totalPrice", totalPrice)
                startActivity(intent)


            }
=======
        myButton = findViewById(R.id.placeOrderButton)

        myButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
>>>>>>> bb81cbb21660816fcdb4b7ac3a76f2c5970c584f
        }

    }

}