# Hystrix 도입 타당성 조사

![hystrix-logo](C:\Users\dsbae\Desktop\hystrix-logo.png)

## 1. 개요

1. 목적

   * Hystrix는 MSA 환경에서의 장애 전파를 막을 수 있다. (Circuit Breakers)
   * Hystrix를 도입하면, 성능 저하가 생긴다. 
   * 이 성능 저하 지표를 토대로 Hystrix 도입의 타당성을 판단한다.

2. 환경

   1. Java 1.8
   2. Spring-boot 2.0.3 RELEASE
   3. MariaDB 5.5
   4. Hystrix 1.5.12


## 2. Hystrix

* 넷플릭스의 OSS중 하나
* 분산 환경을 위한 Latency and Fault Tolerance 시스템 (대기 시간 및 결함 허용)
* Real-Time Operations 지원
* Concurrency (동시성)

## 3. Why?

* 내부적으로 RxJava 사용

### 1. Circuit Breaker

 * 서비스간 의존성이 발생하는 접근 포인트를 분리시켜 장애 전파를 방지
* Fallback을 제공하여 시스템 장애로부터의 복구(Resiliency)를 유연하게 한다.

### 2. Service Monitoring & Alerting

* 별도의 Metrics 서비스를 고려하지 않아도 서비스들 간의 call과 Queuing 상태(Hystrix 내부의 Queue인 경우) 모니터링 가능
* 알림 기능을 통하여 운영 시 장애에 신속하게 대응이 가능

### 3. Concurrency & More

* Timeout, Thread Pool 설정 및 관리, Queuing 기능 제공

