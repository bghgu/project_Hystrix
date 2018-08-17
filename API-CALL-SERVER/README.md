# API-CALL-SERVER

API : https://github.com/bghgu/project_Hystrix/wiki/API-CALL-SERVER

## Hystrix

* @Annotation 방식으로 Hystrix 적용

* RestTemplate을 이용해 USER-API-SERVER의 API CALL 

* Circuit Breaker 발동 조건

  1.User-api server shutdown 시 발동

  2.Respon Status 500시 발동

  3.Thread Pool, Queue가 꽉 찼을 시 발동

  4.동시에 너무 많은 Request가 요청 될 시 발동

  5.Healthy 상황에서, 평균 30번의 Circuit Breaker 발동

  6.기타 INTERNAL SERVER ERROR 시

```
@HystrixCommand(groupKey = "findOneFallback", commandKey = "findOneFallback", fallbackMethod = "findOneFallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "250"), @HystrixProperty(name = "maximumSize", value = "300"),
			@HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
			@HystrixProperty(name = "maxQueueSize", value = "987654321"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "300") }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "300") })
```

## 시작하기

모든 소스코드는 STS+ Window10 + JAVA 8 환경에서 작성되었습니다.

이 프로젝트에서는 아래 같은 **의존성 프로젝트**가 포함되어있습니다. 

**pom.xml** 파일에 아래와 같이 **의존성 프로젝트**를 추가해 주세요.

```
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
	</dependency>	
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
	</dependency>
	<dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<optional>true</optional>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>
```
## 실행하기

window 10 환경

- `jdk8` 과 `maven` 을 설치합니다.
- `JAVA_JOME` 환경변수 설정을 합니다.
- `Path`에 `maven` 환경변수 설정을 합니다.
- 내장 톰캣을 이용해 서버를 배포 합니다.
- spring boot 앱 실행
- `application.properties` 파일이 필요합니다.

```
mvn spring-boot:run
```

- 중지하려면, 키보드에서 `Crtl + C`를 누릅니다.
- `application.properties` 파일이 필요합니다.

AWS EC2 Ubuntu 환경

- `jdk8` 과 `maven` 을 설치합니다.
- 백 그라운드 spring boot 앱 실행
- 내장 톰캣을 사용해 배포합니다.

```
nohup mvn spring-boot:run&
```

- 중지하려면,  `netstat -tnlp` 명령어를 통해 프로세스를 kill 하십시오.

## 배포

* AWS EC2 - 애플리케이션 서버
* AWS RDS - Maria DB 서버
* Docker

## 사용된 도구

* [Spring-boot](https://projects.spring.io/spring-boot/) - Spring-boot 웹 프레임워크
* [Maven](https://maven.apache.org/) - 의존성 관리 프로그램
* [Tomcat](http://tomcat.apache.org/) - 웹 애플리케이션 서버
* [STS](https://spring.io/tools) - IDE
* [AWS EC2](https://aws.amazon.com/ko/ec2/?sc_channel=PS&sc_campaign=acquisition_KR&sc_publisher=google&sc_medium=english_ec2_b&sc_content=ec2_e&sc_detail=aws%20ec2&sc_category=ec2&sc_segment=177228231544&sc_matchtype=e&sc_country=KR&s_kwcid=AL!4422!3!177228231544!e!!g!!aws%20ec2&ef_id=WkRozwAAAnO-lPWy:20180412120123:s) - 클라우드 환경 컴퓨팅 시스템
* [Docker](https://www.docker.com/) - 컨테이너 기반의 오픈소스 가상화 플랫폼

## 저자

* **배다슬** - [bghgu](https://github.com/bghgu)

---


