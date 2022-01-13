package composing

import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis { // 소요된 시간 측정
        val one = async(start = CoroutineStart.LAZY) { doSomeThingUsefulOne111() } //처리하는데 1초
        val two = async(start = CoroutineStart.LAZY) { doSomeThingUsefulTwo222() } //One이 끝나야 시작하며 처리하는데 1초
        one.start() // coroutine 실행
        two.start() // coroutine 실행
        //await() 일때 실행되고 끝날때까지 기다린다. -> one 시작 후 끝날때까지 대기 -> two 시작 후 끝날때까지 대기
        println("The answer is ${one.await()+two.await()}")
    }
    println("Complaeted in $time ms")
}

suspend fun doSomeThingUsefulOne111(): Int {
    println("doSomeThingUsefulOne")
    delay(1000L)
    return 13
}
suspend fun doSomeThingUsefulTwo222(): Int {
    println("doSomeThingUsefulTwo")
    delay(1000L)
    return 24
}

