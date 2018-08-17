# Hystrix 도입 타당성 조사

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

3. 기간 

   2018.07.03 ~ 

## 2. TEST

### Hystrix 도입 전

1. 직접 user api server call

2. api gateway call

### hystrix 도입 후 

1. api gateway call
2. user api server의 Disconnection DB 장애를 발생시킨 뒤 hystrix를 통한 api gateway call
3. 잘못된 라우팅 설정 후 hystrix를 통한 api gateway call (컴포넌트 콜 요청 장애)







## 3. USER API SERVER URI

| 메소드 | uri               | 설명             |
| ------ | ----------------- | ---------------- |
| GET    | /users            | 전체 사용자 조회 |
| GET    | /users/{user_idx} | 특정 사용자 조회 |
| POST   | /users            | 사용자 저장      |
| PUT    | /users/{user_idx} | 특정 사용자 수정 |
| DELETE | /users/{user_idx} | 특정 사용자 삭제 |

## 4. API CALL SERVER URI (Hystrix 도입 대상)

| 메소드 | uri               | 설명             |
| ------ | ----------------- | ---------------- |
| GET    | /users            | 전체 사용자 조회 |
| GET    | /users/{user_idx} | 특정 사용자 조회 |
| POST   | /users            | 사용자 저장      |
| PUT    | /users/{user_idx} | 특정 사용자 수정 |
| DELETE | /users/{user_idx} | 특정 사용자 삭제 |

## 5. Hystrix 설정

1. 동기 방식의 Hystrix Command
2. Thread & Thread Pools 방식의 Isolation

## 6. 추가 사항

1. 비동기 방식, Semaphore 방식
2. Hystrix properties 설정 튜닝

------

1. Dash Board 에서 이전 기록 보기 커스텀
2. 알람 커스텀