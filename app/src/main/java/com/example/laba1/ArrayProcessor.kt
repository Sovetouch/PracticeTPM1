package com.example.laba1

import kotlin.random.Random

class ArrayProcessor {

    fun generateRandomArray(size: Int = 15): IntArray {
        return IntArray(size) { Random.nextInt(-50, 51) }
    }

    fun findFirstNegativeAndLastPositive(array: IntArray): String {
        val firstNegativeIndex = array.indexOfFirst { it < 0 }
        val lastPositiveIndex = array.indexOfLast { it > 0 }

        return buildString {
            append("Сгенерированный массив:\n")
            append(array.joinToString(", "))
            append("\n\n")

            if (firstNegativeIndex != -1) {
                append("Первый отрицательный элемент: индекс $firstNegativeIndex, значение ${array[firstNegativeIndex]}")
            } else {
                append("Отрицательные элементы не найдены")
            }

            append("\n")

            if (lastPositiveIndex != -1) {
                append("Последний положительный элемент: индекс $lastPositiveIndex, значение ${array[lastPositiveIndex]}")
            } else {
                append("Положительные элементы не найдены")
            }
        }
    }
}