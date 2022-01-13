package composing

import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSun()}")
    }
    println("Complaeted in $time ms")
    runBlocking {
        delay(10000L)
    }
}

suspend fun concurrentSun(): Int = coroutineScope{
    val one = async { doSomeThingUsefulOne111111() }
    val two = async { doSomeThingUsefulTwo222222() }
    delay(10L)
    println("Throw Exception!!")
    throw Exception("my exception")

    one.await() + two.await()
}
suspend fun doSomeThingUsefulOne111111(): Int {
    println("doSomeThingUsefulOne")
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo222222(): Int {
    println("doSomeThingUsefulTwo")
    delay(1000L)
    return 24
}

