package composing

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis { // 소요된 시간 측정
        var oneValue: Int = 0
        var twoValue: Int = 0
        val one = launch { oneValue = doSomeThingUsefulOne1() } //처리하는데 1초
        val two = launch { twoValue = doSomeThingUsefulTwo2() }  //One이 끝나야 시작하며 처리하는데 1초
        one.join()
        two.join()
        println("The answer is ${oneValue+twoValue}")
    }
    println("Complaeted in $time ms")
}

suspend fun doSomeThingUsefulOne1(): Int {
    println("doSomeThingUsefulOne")
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo2(): Int {
    println("doSomeThingUsefulTwo")
    delay(1000L)
    return 24
}

