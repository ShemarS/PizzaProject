package com.example.pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
        if (view == mediumRadioButton){
            Toast.makeText(this, "Medium was clicked", Toast.LENGTH_SHORT).show()
        }
        else if (view == largeRadioButton){

        }
        else if (view == exLargeradioButton){

        }
        else {

        }
    }



}