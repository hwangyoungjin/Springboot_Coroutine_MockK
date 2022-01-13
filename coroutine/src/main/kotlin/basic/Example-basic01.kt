package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    GlobalScope.launch {
        delay( 1000L)
        println("world1")
    }
    println("Hello,")
    Thread.sleep(10000L)
}

//fun main(){
//    thread {
//        Thread.sleep(1000L)
//        println("World")
//    }
//    println("Hello,")
//    Thread.sleep(2000L)
//}

