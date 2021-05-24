package com.filip.sample.kotlin.components

class Component4: MyCustomInterface {
    override fun myInterfaceMethod(param1: String) {
        println("shdhasdhj")
    }
}


class Component5: MyCustomInterface {
    override fun myInterfaceMethod(param1: String) {
        val variable = 89
        println(variable)
    }
}

interface MyCustomInterface{

    fun myInterfaceMethod(param1:String)
}