package com.example.pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var names: Array<String> = arrayOf("Codie", "Amber", "Freddy", "Johnathan", "Chica", "Bonnie", "Monty", "Kevin")
        var randomNumber = Random.nextInt(names.size - 1)
        var selectedName = names[randomNumber]

        //Lines 25 & 26 are from a post on stack overflow, I could not figure out how to get date and time using Kotlin
        //https://stackoverflow.com/questions/47006254/how-to-get-current-local-date-and-time-in-kotlin

        val sdf = SimpleDateFormat("hh:mm")
        val currentDate = sdf.format(Date())
        orderPrepTextView.text = "$selectedName started prepping your order at $currentDate PM"
    }

    fun onTipSwitched (view: View) {
        val switch = findViewById<Switch>(R.id.tipSwitch)
        if(switch.isChecked) {
            tipSwitch.text = "Yes ($5.00)"
            tipTextView.text = "Thanks for tipping!"
            tipImageView.visibility = View.INVISIBLE
        }
        else {
            tipSwitch.text = "No ($0.00)"
            tipTextView.text = "Would you like to leave a tip?"
            tipImageView.visibility = View.VISIBLE
        }

    }

}