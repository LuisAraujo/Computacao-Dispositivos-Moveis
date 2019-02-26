package com.example.ktempconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton


class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var celciusRadioButton: RadioButton
    lateinit var fahreinheitRadioButton: RadioButton
    lateinit var converterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //pegando as referencias dos elementos da view
        editText = findViewById(R.id.valorTemp) as EditText
        celciusRadioButton  =  findViewById(R.id.celciusRadio) as RadioButton
        fahreinheitRadioButton  =  findViewById(R.id.fahreinheitRadio) as RadioButton
        converterButton = findViewById(R.id.convertButton) as Button
        converterButton.setOnClickListener { converter(it)}

    }

    fun converter(view: View){
        var temp: Double = editText.text.toString().toDouble()


        if(celciusRadioButton.isChecked)
            temp = (temp - 32) * 5/9
        else if(fahreinheitRadioButton.isChecked)
            temp = temp * 9/5 + 32


        editText.setText( temp.toString() )

    }
}
