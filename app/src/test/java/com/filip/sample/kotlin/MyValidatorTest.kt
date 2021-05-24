package com.filip.sample.kotlin

import com.filip.sample.kotlin.components.Component1
import com.filip.sample.kotlin.components.Component2
import com.filip.sample.kotlin.components.Component3
import com.filip.sample.kotlin.components.Component4
import com.filip.sample.kotlin.components.Component5
import com.filip.sample.kotlin.components.MyCustomInterface
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test


class MyValidatorTest {

    @Test
    fun shouldReturnInitialValues() {
        val tested1 = MyValidator("Silvia",22)
        val tested2 = MyValidator("Stoycho",0)
        val tested3 = MyValidator("Filip",5)

        assertEquals("Silvia", tested1.name)
        assertEquals("Stoycho", tested2.name)
        assertEquals("Filip", tested3.name)
        assertEquals(22,tested1.age)
    }

    @Test
    fun shouldReturnDefaultAge(){
        val tested1 = MyValidator("Didi")
        assertEquals("Didi",tested1.name)
        assertEquals(44, tested1.age)
    }

    @Test
    fun shouldReturnValidName(){
        val tested = MyValidator("Silvia")
        assertTrue(tested.isValidName())
    }

    @Test
    fun shouldReturnInvalidName(){
        val tested = MyValidator ("Blahaja")
        assertFalse(tested.isValidName())
    }

    @Test
    fun shouldReturnValidAge(){
        assertTrue(MyValidator.isValidAge(34))
    }

    @Test
    fun shouldReturnInvalidAge(){
        assertFalse(MyValidator.isValidAge(12))
    }
    @Test
    fun myDataTest(){
        val tested1 = MyData("gafaf",90, "Gdddd","56",22)
        val tested2 = MyData("ghghg",78, "ddfff", age = 74)
        val tested3 = MyData("ggaga",76)
        val tested4 = MyData("ggaga",76, age = 90)
    }

    @Test
    fun myListTest(){
        val list = mutableListOf<Int>(67,89,77,66)
        list.forEach { println(it) }
        if (list.isNotEmpty()) {
            list.add(1, 766)
            list.forEach { println(it) }
            list.removeAt(1)
            list.forEach { println(it) }

            println("------" + list.get(list.size - 1))
            println("******" + list.get(0))
            println("=======" + list.get(list.size / 2))

            val newList = list.map { it + 2 }
            newList.forEach { println("--++--++" + it) }
        }
    }

    @Test
    fun myMapTest(){
        val map = mutableMapOf(45 to "Silvia", 33 to "Bubi")
        map.forEach { key, value ->
            println(key)
            println(value)
        }

        map.put(7,"bati")
        map.forEach { key, value ->
            println(key)
            println(value)
        }
        map.remove(7)
        map.forEach { key, value ->
            println(key)
            println(value)
        }

        val mapToList = map.map { it.value + "gfhhj" }

        mapToList.forEach { println("--++--++" + it) }
    }

    @Test

    fun componentsTest(){
        val inter: MyCustomInterface = Component5()
        val com3 = Component3()
        val com2 = Component2(inter)
        val myComponent: Component1 = Component1(com2, com3)
        myComponent.amamm()
    }


}