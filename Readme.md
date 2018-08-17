# Project-Hystrix

![hystrix-logo](https://github.com/bghgu/project_Hystrix/blob/master/img/hystrix-logo.png)

* Spring-Hystrix 도입 사전 조사 및 준비
* 2018.07.02 ~ 2018.08.10

## 1. 개요

* Hystrix는 Circuit Breaker 패턴으로 MSA 환경에서 의존성있는 Component들 끼리 장애 전파를 막을 수 있다.
* Hystrix를 도입하면, 약간의 성능 저하가 생긴다. 
* 임의의 MSA 환경을 구축 후 Hystrix 도입 전, 후의 API CALL TPS를 측정한다.
* 여러 시나리오 별로 TPS를 측정한다.
* TPS 지표를 토대로 Hystrix 도입의 타당성을 판단한다.

## 2. Hystrix

* Netflix OSS의 하나
* 분산 환경(MSA)에서 장애 내성(Fault Tolerance)과 지연 내성(Latency Tolerance)을 위한 라이브러리
* 최소한의 부하로 운영이 가능
* Circuit Breaker, DashBoard 

## 3. Circuit Breaker

* 서비스간 의존성이 발생하는 접근 포인트를 분리시켜서 장애 전파를 막는다.
* Fallback을 제공하여 시스템 장애로부터 복구(Resiliency)를 유연하게 한다.
* Thread Pool 방식과 Semaphore 방식이 있다.
* 동기 방식과 비동기 방식으로 구성할 수 있다

![isolation](https://github.com/bghgu/project_Hystrix/blob/master/img/isolation.png)

### 발동 조건

20번(기본값)의 메소드 실행 중, 10번 이상(50% 기본값) 실패 시 Circuit Breaker 발동

19번의 메소드 실행 중, 19번이 모두 실패하더라도, 기본 충족 수(20)번 메소드가 실행되지 않았기 때문에 Circuit Breaker 발동 안함

### 해제 조건

5초 이내(기본값) 단 하나의 메소드 다시 실행, 성공 시 Circuit Breaker 닫힘, 실패 시 열림 유지

## 4. DashBoard

![dash-board](https://github.com/bghgu/project_Hystrix/blob/master/img/dash-board.png)

* 실시간 모니터링을 지원한다.
* 별도의 Metrics 서비스를 고려하지 않아도 서비스들 간의 호출과 Queuing 상태(Hystrix 내부의 Queue인 경우)를 모니터링 할 수 있다.

## 5. Hystrix Architecture

![hystrix](https://github.com/bghgu/project_Hystrix/blob/master/img/hystrix.png)

1. HystrixCommand, HystrixObservableCommand 객체 생성
2. Command 실행
3. 캐시 상태 확인
4. 회로 상태 확인
5. 사용 가능한 Thread Pool/Semaphore가 있는지 확인
6. HystrixObservableCommand.construc() / HystrixComand.run() 실행
7. Calculate Circuit health
8. Fallback 실행
9. 응답 반환

## 6. Hystrix Thread Pool

![thread](https://github.com/bghgu/project_Hystrix/blob/master/img/thread.png)

* Thread Pool 계산식

  (Peak일때의 초당 req X 초당 99번재 지연) + 여유분

## 7.  Circuit Breaker 발동 상황

1. Hystrix Method Fail시
2. Thread Pool, Queue가 꽉 찼을 시
3. 동시에 너무 많은 Request가 요청 될 시
4. 기타 INTERNAL SERVER ERROR 시

