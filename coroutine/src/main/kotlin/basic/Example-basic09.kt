package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        repeat(5) { i ->
            println("Croutine A, $i")
            delay(10L)
        }
    }
    launch {
        repeat(5) { i ->
            println("Croutine B, $i")
            delay(10L)
        }
    }
    println("suspend, resume Test")
}

/**
 * 실행되는 Thread 이름 출력을 위해 println overriding
 */
fun <T> println(msg: T){
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
