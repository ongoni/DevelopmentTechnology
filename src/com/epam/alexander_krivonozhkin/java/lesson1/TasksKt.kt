package com.epam.alexander_krivonozhkin.java.lesson1

class TasksKt {

    private fun getFilledArray(length: Int) : IntArray {
        return (0 until length)
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
        println("task 1:")
        val array = getFilledArray(20)
        print(array)
        println()
        println(Math.abs(getMinimum(array)) - Math.abs(getAverage(array)))
    }

    private fun getFilledList(n: Int) : MutableList<String> {
        var text: MutableList<String>
        do {
            print("enter text: ")
            text = readLine()!!.split(' ').toMutableList()
            if (text.size < n) println("need to enter $n words!")
        } while (text.size < n)

        return text.subList(0, n)
    }

    private fun containsUniqueElements(word: String) : Boolean = word.length == word.toCharArray().distinct().size

    fun task2() {
        println("task 2:")
        print("enter n: ")
        val n = readLine()!!.toInt()

        println(getFilledList(n).first { x -> containsUniqueElements(x) })
    }

    fun task3() {
        println("task 3:")

        while (true) {
            print("enter a: ")
            val a = readLine()!!.toDouble()
            print("enter b: ")
            val b = readLine()!!.toDouble()
            print("enter operation (+, -, *, /): ")
            val operation = readLine()!!.first()

            val result = when (operation) {
                '+' -> a.plus(b)
                '-' -> a.minus(b)
                '*' -> a.times(b)
                '/' -> a.div(b)
                else -> 0.0
            }

            println(result)
        }
    }

}