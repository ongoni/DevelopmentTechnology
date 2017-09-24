package com.epam.alexandr_krivonozhkin.java.lesson1.task1

import java.util.*

class TasksKt {

    private fun getFilledArray(length: Int) : IntArray {
        return (0..length)
                .map { -10 + (Math.random() * 20).toInt() }
                .toIntArray()
    }

    private fun getMinimum(array: IntArray) : Int = array.min() ?: 0

    private fun getAverage(array: IntArray) : Double = array.sum().toDouble() / array.size

    private fun print(array: IntArray) {
        array.forEach {
            print(it.toString() + " ")
        }
    }

    fun task1() {
        val array = getFilledArray(20)
        print(array)
        println()
        println(Math.abs(getAverage(array)) - Math.abs(getMinimum(array)))
    }

    private fun getFilledList(n: Int) : MutableList<String> {
        var text = mutableListOf<String>()
        do {
            print("enter text: ")
            text = readLine()!!.split(' ').toMutableList()
            if (text.size < n) println("need to enter $n words!")
        } while (text.size < n)

        return text.subList(0, n)
    }

    private fun containsUniqueElements(word: String) : Boolean {
        return word.length == word.toCharArray().distinct().size
    }

    fun task2() {
        print("enter n: ")
        val n = readLine()!!.toInt()

        println(getFilledList(n).first { x -> containsUniqueElements(x) })
    }

}