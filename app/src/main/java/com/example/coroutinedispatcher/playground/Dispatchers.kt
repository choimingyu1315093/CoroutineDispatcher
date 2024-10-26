package com.example.coroutinedispatcher.playground

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Thread 내에서 동작하는 일시 중단 가능한 작업의 단위를 Coroutine 이라고 한다.
//그냥 launch 라고 사용해도 되지만, 코루틴에게 어느 스레드에서 실행될지 지정해줘서 성능을 최적화 하기 위해 Dispatchers을 사용한다.
//Dispatchers에는 Main, IO, Default 등이 있다.
//Main은 메인 스레드에서 실행되니까 UI 작업할 때
//IO는 백그라운드 스레드에서 실행되니까 네트워크 작업이나 파일 입/출력 작업할 때
//Default는 복잡한 연산이나 데이터 처리 등 CPU를 많이 쓰는 작업에 사용 된다.
//주로 Default랑 IO를 사용한다.
fun main(): Unit = runBlocking {
    launch {
        println("부모의 콘텍스트 ${Thread.currentThread().name}")
    }

    launch (Dispatchers.Default){
        println("Default ${Thread.currentThread().name}")
    }

    launch (Dispatchers.IO){
        println("IO ${Thread.currentThread().name}")
    }
}

