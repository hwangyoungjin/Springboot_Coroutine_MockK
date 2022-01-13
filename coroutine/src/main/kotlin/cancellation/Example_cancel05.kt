package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L){
        repeat(1000){ i ->
            println("i'm sleeping $i")
            delay(500L)
        }
        "Done"
    }
    println("Result is: $result")
}