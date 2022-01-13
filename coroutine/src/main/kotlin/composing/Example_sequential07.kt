package composing

import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    }catch (e: ArithmeticException){
        println("Computation")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async {
        println("Second child Throw Exception!!")
        throw ArithmeticException("my exception")
    }
    one.await() + two.await()
}

