package composing

import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

fun main() {
    try {
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync()
            val two = somethingUsefulTwoAsync()

            println("Throw Exception!!")
            throw Exception("my exception")

            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }

        }
    } catch (e: Exception){}

    runBlocking {
        delay(10000L)
    }
}

fun somethingUsefulOneAsync() = GlobalScope.async {
    println("start, one")
    val res = doSomeThingUsefulOne11111()
    println("end, one")
    res
}
fun somethingUsefulTwoAsync() = GlobalScope.async {
    println("start, two")
    val res = doSomeThingUsefulTwo22222()
    println("end, two")
    res
}
suspend fun doSomeThingUsefulOne11111(): Int {
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo22222(): Int {
    delay(1000L)
    return 24
}

