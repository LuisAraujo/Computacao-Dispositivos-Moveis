package com.example.tempconvert

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import  App

class MainActivity : AppCompatActivity() {

    lateinit var textTemp: EditText
    lateinit var buttonF: Button
    lateinit var buttonC: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTemp = findViewById(R.id.valorTemp) as EditText
        buttonF  =  findViewById(R.id.convertFButton) as Button
        buttonC  =  findViewById(R.id.convertCButton) as Button
        buttonF.setOnClickListener {
            var value: Double = textTemp.text.toString().toDouble()
            var app = App()
            textTemp.setText( app.convertToFahrenheit(value).toString() )

        }

        buttonC.setOnClickListener {

            var value: Double = textTemp.text.toString().toDouble()
            var app = App()
            textTemp.setText( app.convertToCelcius(value).toString() )

        }

    }
}


