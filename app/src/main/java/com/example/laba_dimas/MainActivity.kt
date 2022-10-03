package com.example.laba_dimas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        editText.addTextChangedListener() {
            if (editText.text.isNotEmpty()) {
                but_1.isEnabled = true
            }
        }
        
        but_1.setOnClickListener() {
            generateString.set_n(editText.text.toString().toInt())
            for (i in 1..20) {
                if (i == 1) {
                    text_1.text=generateString.generatebigString()
                } else {
                    text_1.text = text_1.text.toString() + "\n" + generateString.generatebigString()
                }
            }
            for (i in 1..20) {
                if (i == 1) {
                    text_2.text=generateString.generateLittleString()
                } else {
                    text_2.text = text_2.text.toString() + "\n" + generateString.generateLittleString()
                }
            }
            but_2.isEnabled=true
            but_3.isEnabled=true
        }

        but_2.setOnClickListener(){
            text_2.text=null
            var l_big : MutableList<String> = mutableListOf()
            var l_lit : MutableList<String> = mutableListOf()
            l_big=generateString.sort_big()
            l_lit=generateString.sort_little()
            for(i in 0..l_big.size-1 ){
                if(i==0){text_1.text=l_big[i]}
                else {
                    text_1.text = text_1.text.toString() + "\n" + l_big[i]
                }
            }
            for(i in 0..l_lit.size-1 ){
                if(i==0){text_2.text=l_lit[i]}
                else {
                    text_2.text = text_2.text.toString() + "\n" + l_lit[i]
                }
            }
        }

        but_3.setOnClickListener(){
            but_1.isEnabled=false
            but_2.isEnabled=false
            but_3.isEnabled=false
            text_1.text="Слова длина которых больше заданного числа n"
            text_2.text="Слова длина которых меньше или равно заданного числа n"
            editText.text.clear()
            generateString.clear()
        }


    }

}