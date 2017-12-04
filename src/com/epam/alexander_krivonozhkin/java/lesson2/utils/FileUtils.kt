package com.epam.alexander_krivonozhkin.java.lesson2.utils

import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car
import com.epam.alexander_krivonozhkin.java.lesson2.classes.PassengerCar
import java.io.File

class FileUtils {

    fun write(content: String, to: File) = to.writeText(content)

    fun readAll(file: File) : String = file.readText()

    fun readCarsFrom(file: File) : List<Car> {
        val result: MutableList<Car> = mutableListOf()
        file.bufferedReader().lines().forEach {
            val args = it.split("; ")
            result.add(PassengerCar(args[0], args[1], args[2].toDouble(), args[3].toDouble(), args[4].toInt()))
        }

        return result
    }

}