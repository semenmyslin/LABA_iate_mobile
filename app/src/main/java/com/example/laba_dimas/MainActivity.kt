package com.example.laba_dimas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    var generateString: GenerateString = GenerateString(0)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text_1: TextView = findViewById(R.id.textOne)
        var text_2: TextView = findViewById(R.id.textTwo)
        var editText: EditText = findViewById(R.id.editInputN)
        var but_1: Button = findViewById(R.id.butOne)
        var but_2: Button = findViewById(R.id.butTwo)
        var but_3: Button = findViewById(R.id.butThree)
        var text : TextView = findViewById(R.id.textText)


        editText.addTextChangedListener() {
            if (editText.text.isNotEmpty()) {
                but_1.isEnabled = true
            }
        }

        but_1.setOnClickListener() {
            text.text=generateString.getText()
            val a= text.text
            val b =a
            text.visibility=View.VISIBLE

            but_2.isEnabled=true
            but_3.isEnabled=true
        }

        but_2.setOnClickListener(){
            text_1.text=""
            text_2.text=""
            generateString.sort(editText.text.toString().toInt())
            for(i in 0 until generateString.getBig().size) {
                text_1.text=text_1.text.toString()+"\n"+generateString.getBig()[i]
            }
                for(i in 0 until generateString.getLittle().size){
                    text_2.text=text_2.text.toString()+"\n"+generateString.getLittle()[i]
                }
            generateString.clearStringSorted()
        }

        but_3.setOnClickListener(){
            but_1.isEnabled=false
            but_2.isEnabled=false
            but_3.isEnabled=false
            text.visibility=View.GONE
            text_1.text="Слова длина которых больше заданного числа n"
            text_2.text="Слова длина которых меньше или равно заданного числа n"
            editText.text.clear()

        }


    }

}