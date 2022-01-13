package composing

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis { // 소요된 시간 측정
        val one = doSomeThingUsefulOne() //처리하는데 1초
        val two = doSomeThingUsefulTwo() //One이 끝나야 시작하며 처리하는데 1초
        println("The answer is ${one+two}")
    }
    println("Complaeted in $time ms")
}

suspend fun doSomeThingUsefulOne(): Int {
    println("doSomeThingUsefulOne")
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo(): Int {
    println("doSomeThingUsefulTwo")
    delay(1000L)
    return 24
}

/**
 * 실행되는 Thread 이름 출력을 위해 println overriding
 */
fun <T> println(msg: T){
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}