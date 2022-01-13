package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        try {
            repeat(1000) { i ->
                println("job: i'm sleeping $i")
                delay(500L)
            }
        } finally {
            /**
             * resource 마무리 작업하는 공간
             */
            println("job: i'm running finally")
        }
    }
    delay(1300L)
    job.cancelAndJoin()
    println("main: now i can quit")
}