Dispatchers
Thread 내에서 동작하는 일시 중단 가능한 작업의 단위를 Coroutiner라고 한다.
그냥 사용해도 문제 없지만 어느 스레드에서 작업할 지 정해주면 성능이 더 좋아진다.
Dispatcher에는 Main, IO, Default 등이 있는데
Main은 메인 스레드에서 실행되니까 UI 작업할 때,
IO는 백그라운드 스레드에서 실행되니까 네트워크, 파일 입/출력 작업할 때,
Default는 복잡한 연산이나 데이터 처리 등 CPU 사용이 많을 때 사용한다.

그리고 launch(Job())은 자식에서 제외!! job.join 해도 기다려주지 않는다. 
