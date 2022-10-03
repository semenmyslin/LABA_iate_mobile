package com.example.laba_dimas

class GenerateString(var n : Int) {
    private var listBig : MutableList<String> = mutableListOf()
    private var listLittle : MutableList<String> = mutableListOf()
    fun generatebigString() : String{
        if(listBig.size==20){
            listBig.clear()
        }
        var allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        var string : String


        string = (1..((n+1)..(n+10)).random())
            .map { allowedChars.random() }
            .joinToString("")
        listBig.add(string)
            return string
    }

    fun generateLittleString() : String{
        if(listLittle.size==20){
            listLittle.clear()
        }
        var allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        var string : String
        string = (1..(1..n).random())
            .map { allowedChars.random() }
            .joinToString("")
        listLittle.add(string)
        return string
    }

    fun sort_little() : MutableList<String>{
        listLittle.sortBy { it.length }
        return listLittle
    }

    fun sort_big() : MutableList<String>{
        listBig.sortBy { it.length }
        return listBig
    }

    fun set_n(n: Int){
        this.n=n
    }

    fun clear(){
        listLittle.clear()
        listBig.clear()
        this.n=0
    }




}