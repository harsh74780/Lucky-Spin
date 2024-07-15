package com.example.luckyspin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var colorSpinner: Spinner
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView
    private var selectedColor: String? = null
    private val colors = arrayOf("Red", "Blue", "Green", "Yellow", "Purple")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorSpinner = findViewById(R.id.colorSpinner)
        submitButton = findViewById(R.id.submitButton)
        resultTextView = findViewById(R.id.resultTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorSpinner.adapter = adapter

        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedColor = colors[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        submitButton.setOnClickListener {
            playGame()
        }
    }

    private fun playGame() {
        val randomColor = colors[Random().nextInt(colors.size)]

        if (selectedColor == randomColor) {
            resultTextView.text = "You guessed right! The color is $randomColor"
        } else {
            resultTextView.text = "Wrong guess! The color was $randomColor"
        }
    }
}