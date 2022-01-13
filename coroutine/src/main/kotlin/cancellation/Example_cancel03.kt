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
             * coroutine이 종료되어도 재개하여 이후해 필요한 기능을 작성가능
             */
            withContext(NonCancellable){
                println("job: i'm running finally")
                delay(1000L)
                println("job: i'm just delayed for 1 sec becauese i'm NonCancellable")
            }
        }
    }
    delay(1300L)
    job.cancelAndJoin()
    println("main: now i can quit")
}