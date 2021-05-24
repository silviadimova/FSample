package com.filip.sample.kotlin

class MyValidator(val name :String, var age: Int = 44) {

    companion object{
        fun isValidAge(someAge: Int): Boolean {
            return someAge >= 21
        }
    }

    fun isValidName(): Boolean {
        val list = mutableListOf("Silvia","Stoycho","Filip","Irmena")
        return list.contains(name)
    }
}

class MyData (
        val name: String,
        val doorNumber: Int,
        val address: String = "Baba",
        val address123: String = "yggy",
        val age: Int = 0
)
