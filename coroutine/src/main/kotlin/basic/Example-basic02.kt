package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//fun main(){
//    GlobalScope.launch {
//        delay(1000L)
//        println("world")
//    }
//    println("hello")
//    runBlocking {
//        delay(2000L)
//        println("hi")
//    }
//}
fun main() = runBlocking {
        this.launch {
            delay(1000L)
            myWorld()
        }
        println("hello")
        delay(500L)
}

suspend fun myWorld(){
    delay(1000L)
    println("world")
}