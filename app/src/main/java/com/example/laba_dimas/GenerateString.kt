package com.example.laba_dimas

class GenerateString(var n : Int) {
    private var listBig : MutableList<String> = mutableListOf()
    private var listLittle : MutableList<String> = mutableListOf()

    private var text : String = "1 111 222 3333 44444 555555 4854054904 1 53 53ш53 ооыолпып"
    var textSeparated = text.split(" ").toTypedArray() // разбиваем строку на пробелы

    fun sort(length : Int){ // разместил по массивам
        for(i in textSeparated.indices){
            if(textSeparated[i].length>=length){
                listBig.add(textSeparated[i])
            }
            else{
                listLittle.add(textSeparated[i])
            }
        }
    }

    fun getLittle() : MutableList<String>{
        return listLittle
    }

    fun getBig() : MutableList<String>{
            return  listBig
    }

    fun getText() : String{
        return text
    }

    fun clearStringSorted(){
        listBig= mutableListOf()
        listLittle= mutableListOf()
    }




}