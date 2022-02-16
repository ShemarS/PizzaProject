package com.example.pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var total = 0.00;
    var sizeChosen = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaList = listOf("BBQ Chicken", "Hawaiian", "Margherita", "Pepperoni")
        val pizzaAdapter = ArrayAdapter<String>(
            this, android.R.layout. simple_spinner_dropdown_item, pizzaList)
        pizzaSelectionSpinner.adapter = pizzaAdapter
    }

    fun radioClick(view: View){
// check which radio button was clicked
        if (view == mediumRadioButton) {
            if (sizeChosen == "Large") {
                total -= 13.99
            }
            else if (sizeChosen == "XLarge") {
                total -= 15.99
            }
            else if(sizeChosen == "Medium") {
                Toast.makeText(this, "Medium is already selected!", Toast.LENGTH_SHORT).show()
                return
            }
            total += 9.99
            sizeChosen = "Medium"
        }
        else if (view == largeRadioButton){
            if(sizeChosen == "Medium") {
                total -= 9.99
            }
            else if (sizeChosen == "XLarge") {
                total -=15.99
            }
            else if(sizeChosen == "Large") {
                Toast.makeText(this, "Large is already selected!", Toast.LENGTH_SHORT).show()
                return
            }
            total += 13.99
            sizeChosen = "Large"
            //Toast.makeText(this, "Total: $total", Toast.LENGTH_SHORT).show()
        }
        else if (view == exLargeRadioButton){
            if(sizeChosen == "Medium") {
                total -= 9.99
            }
            else if (sizeChosen == "Large") {
                total -=13.99
            }
            else if(sizeChosen == "XLarge") {
                Toast.makeText(this, "XLarge is already selected!", Toast.LENGTH_SHORT).show()
                return
            }
            total += 15.99
            sizeChosen = "XLarge"
            //Toast.makeText(this, "Total: $total", Toast.LENGTH_SHORT).show()
        }
        totalTextView.text = total.toString()
    }



}