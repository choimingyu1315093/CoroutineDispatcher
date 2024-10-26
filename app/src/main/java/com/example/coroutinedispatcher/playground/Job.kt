package com.example.coroutinedispatcher.playground

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//부모 코루틴 또는 자식 코루틴이 취소가되면 그에 포함된 모든 코루틴이 취소 된다.
fun main() = runBlocking { //증부모
    val job = launch { //부모
        launch (Job()){ //내놓은 자식: 자기가 따로 Job을 구했다
            println("launch1")
            delay(1000L)
            println("3")
        }

        launch { //자식
            println("launch2")
            delay(1000L)
            println("1")
        }
    }

    delay(500L)
    job.cancelAndJoin() //자식만 취소하고, 기다린다
    delay(1000L)
}

