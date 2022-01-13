package composing

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis { // 소요된 시간 측정
        val one = async { doSomeThingUsefulOne11() } //처리하는데 1초
        val two = async { doSomeThingUsefulTwo22() } //One이 끝나야 시작하며 처리하는데 1초
        println("The answer is ${one.await()+two.await()}")
    }
    println("Complaeted in $time ms")
}

suspend fun doSomeThingUsefulOne11(): Int {
    println("doSomeThingUsefulOne")
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo22(): Int {
    println("doSomeThingUsefulTwo")
    delay(1000L)
    return 24
}

