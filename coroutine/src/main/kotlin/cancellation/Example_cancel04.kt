package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    withTimeout(1300L){
        repeat(1000){ i ->
            println("i'm sleeping $i")
            delay(500L)
        }
    }
}