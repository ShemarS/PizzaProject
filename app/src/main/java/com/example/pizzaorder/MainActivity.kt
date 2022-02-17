package com.example.pizzaorder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var total = 0.00
    var sizeChosen = ""
    val UPPER_LIMIT = 65
    val LOWER_LIMIT = 15
    var orderEstimate = generateRandom()
    private val currFormat = DecimalFormat("##.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        getSharedPreferences("total", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pizzaList = listOf("BBQ Chicken", "Hawaiian", "Margherita", "Pepperoni")
        val pizzaAdapter = ArrayAdapter<String>(this, android.R.layout. simple_spinner_dropdown_item, pizzaList)
        pizzaSelectionSpinner.adapter = pizzaAdapter
        val myImg = findViewById<ImageView>(R.id.pizzaImageView)
        pizzaSelectionSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>,view: View,position: Int, id: Long){
                when (position) {
                    0 -> {
                        myImg.setImageResource(R.drawable.bbq_chicken)
                        pizzaSelectionTextView.text = "BBQ Chicken"
                    }
                    1 -> {
                        myImg.setImageResource(R.drawable.hawaiian)
                        pizzaSelectionTextView.text = "Hawaiian"
                    }
                    2 -> {
                        myImg.setImageResource(R.drawable.margheritta)
                        pizzaSelectionTextView.text = "Margherita"
                    }
                    3 -> {
                        myImg.setImageResource(R.drawable.pepperoni)
                        pizzaSelectionTextView.text = "Pepperoni"
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putDouble("total", total)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedTotal = savedInstanceState.getDouble("total")
        totalTextView.text = "Total: $savedTotal"
    }


    fun onRadioClick(view: View){
        when (view) {
            mediumRadioButton -> {
                when (sizeChosen) {
                    "Large" -> {
                        total -= 13.99
                    }
                    "XLarge" -> {
                        total -= 15.99
                    }
                    "Medium" -> {
                        Toast.makeText(this, "Medium is already selected!", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                total += 9.99
                sizeChosen = "Medium"
            }
            largeRadioButton -> {
                when (sizeChosen) {
                    "Medium" -> {
                        total -= 9.99
                    }
                    "XLarge" -> {
                        total -=15.99
                    }
                    "Large" -> {
                        Toast.makeText(this, "Large is already selected!", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                total += 13.99
                sizeChosen = "Large"
            }
            exLargeRadioButton -> {
                when (sizeChosen) {
                    "Medium" -> {
                        total -= 9.99
                    }
                    "Large" -> {
                        total -=13.99
                    }
                    "XLarge" -> {
                        Toast.makeText(this, "XLarge is already selected!", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                total += 15.99
                sizeChosen = "XLarge"
            }
        }
        total = (currFormat.format(total)).toString().toDouble()
        totalTextView.text = "Total: $${total.toString()}"
    }

    fun onChecked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.exCheeseCheckBox -> {
                    if (checked) {
                        total += 1.69
                    }
                    else {
                        total -= 1.69
                    }
                }
                R.id.mushroomCheckBox -> {
                    if (checked) {
                        total += 1.69
                    }
                    else {
                        total -= 1.69
                    }
                }
                R.id.onionsCheckBox -> {
                    if (checked) {
                        total += 1.69
                    }
                    else {
                        total -= 1.69
                    }
                }
                R.id.spinachCheckBox -> {
                    if (checked) {
                        total += 1.69
                    }
                    else {
                        total -= 1.69
                    }
                }
                R.id.broccoliCheckBox -> {
                    if (checked) {
                        total += 1.69

                    }
                    else {
                        total -= 1.69

                    }
                }
                R.id.blackOlivesCheckBox -> {
                    if (checked) {
                        total += 1.69

                    }
                    else {
                        total -= 1.69

                    }
                }
                R.id.tomatoesCheckBox -> {
                    if (checked) {
                        total += 1.69

                    }
                    else {
                        total -= 1.69

                    }
                }
            }
        }
        total = (currFormat.format(total)).toString().toDouble()
        totalTextView.text = "Total: $${total.toString()}"
    }

    fun onSwitched (view: View) {
        val switch = findViewById<Switch>(R.id.deliverySwitch)
        if(switch.isChecked) {
            deliverySwitch.text = "Yes ($2.00)"
            total += 2.00
        }
        else {
            deliverySwitch.text = "No ($0.00)"
            total -= 2.00
        }
        total = (currFormat.format(total)).toString().toDouble()
        totalTextView.text = "Total: $${total.toString()}"
    }

    private fun generateRandom(): Int {
        return Random.nextInt(LOWER_LIMIT, UPPER_LIMIT)
    }

    fun onOrderClicked(view: View) {
        Toast.makeText(this, "Awesome! You order has been placed and should be ready in $orderEstimate Minutes!", Toast.LENGTH_SHORT).show()
        trackOrderButton.visibility = View.VISIBLE
    }

    fun onTrackOrderClicked(view: View) {
        val myIntent = Intent(this, MainActivity2::class.java)
        startActivity(myIntent)
    }
}