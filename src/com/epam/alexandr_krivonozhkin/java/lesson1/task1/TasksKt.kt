package com.epam.alexandr_krivonozhkin.java.lesson1.task1

class TasksKt {

    private fun getFilledArray(length: Int) : IntArray {
        return (0..length)
                .map { -10 + (Math.random() * 20).toInt() }
                .toIntArray()
    }

    private fun getMinimum(array: IntArray) : Int = array.min() ?: 0

    private fun getAverage(array: IntArray) : Int = array.sum() / array.size

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

}