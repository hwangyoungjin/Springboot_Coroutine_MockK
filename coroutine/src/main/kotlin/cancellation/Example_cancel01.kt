package cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Example_cancel01 {
}

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: i'm sleeping $i")
            delay(5L)
        }
    }

    delay(14L)
    println("main: i'm tired of waiting")
    job.cancel()
    println("main: now i can quit")
}