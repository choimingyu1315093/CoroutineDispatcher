package com.example.coroutinedispatcher.playground

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//둘다 자식일때는 첫 번째 launch 기다린 후에 두 번째 launch 작업하는데, 첫 번째 launch에 Job()을 넣으면 더 이상 자식 코루틴이 아니라서
//작업이 다 끝나지 않더라도 종료시킨다.
fun main() = runBlocking {
    val elapsed = measureTimeMillis {
        val job = launch {
            launch(Job()) {
                println("launch1")
                for(i in 0..500){
                    println("for $i")
                    delay(10L)
                }
//                delay(5000L)
            }

            launch {
                println("launch2")
                delay(10L)
            }
        }
        job.join()
    }
    println(elapsed)
}