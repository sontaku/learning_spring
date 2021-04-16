# Spring framework







## AOP 

Aspect Oriented Programming : 관점 지향 프로그래밍



## 설치

### 1. STS(Spring Tool Suite)

- https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3

  - Spring Tool Suite 3.9.16 ([New and Noteworthy](https://docs.spring.io/sts/nan/v3916/NewAndNoteworthy.html))

    full distribution on Eclipse 4.19

    - https://download.springsource.com/release/STS/3.9.16.RELEASE/dist/e4.19/spring-tool-suite-3.9.16.RELEASE-e4.19.0-win32-x86_64.zip
    - STS.ini 수정
      - -Dosgi.requiredJavaVersion=1.8

  - JDK 1.8버전은 아래로 설치

  - Spring Tool Suite 3.9.11 ([New and Noteworthy](https://docs.spring.io/sts/nan/v3911/NewAndNoteworthy.html))

    full distribution on Eclipse 4.14

    - https://download.springsource.com/release/STS/3.9.11.RELEASE/dist/e4.14/spring-tool-suite-3.9.11.RELEASE-e4.14.0-win32-x86_64.zip

- **4.X 버전부터는 Spring Boot만 지원**한다.

- 그래서 Spring project를 생성할 수 있는 3.X 버전 설치 권장한다.



### 2. Maven project 변환

프로젝트 우클릭 -> maven -> convert to maven project



### 3. Spring context 주입

https://mvnrepository.com/artifact/org.springframework/spring-context/5.1.5.RELEASE

pom.xml에 주입

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.1.5.RELEASE</version>
</dependency>
```









## 프레임워크

### 프레임워크란?

프레임워크는 애플리케이션들의 최소한의 공통점을 찾아 하부 **구조를 제공**함으로써 개발자들로 하여금 시스템의 하부 구조를 구현하는데 들어가는 **노력을 절감**하게 하는것

### 프레임워크 장점

- 비기능적인 요소들을 초기 개발 단계마다 구현해야하는 불합리함을 극복해줌
- 기능적인 요구사항에 집중할 수 있도록 해줌
- 디자인 패턴과 마찬가지로 반복적으로 발견되는 문제를 해결하기 위한 특화된 솔루션 제공

### 프레임워크 vs 디자인패턴

- 디자인패턴
  - 설계에 필요한 구조적 가이드라인 제공
  - 구체적으로 구현된 코드를 제공하지 않음
- 프레임워크
  - 디자인패턴이 적용된 **클래스 라이브러리 제공**
  - 구조적인 틀과 구현코드 함께 제공



### 프레임워크 vs 클래스 라이브러리

- 클래스 라이브러리
  - 1
- 프레임워크
  - 1





## 스프링 프레임워크

### Spring 이란?

> 자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크

- Application Framework
- 경량급
  - 스프링은 단순 개발 툴과 개발환경으로, 필요시 등장하던 프레임워크나 서버환경에 의존적인 부분 제거
- 개발을 편하게 해준다
  - 기본 설정과 적용기술만 잘 선택하고 준비하면, 개발상황에서 코드나 API에 대해 신경 쓸 일이 없다



### Spring version

- 1.X
- 2.X
  - Spring Sequrity
- 3.X
  - RESTful
- 4.X
  - Web Socket
- 5.X





## DI 

>  Dependency Injection 의존성 주입







### bean 생성

```xml
<bean id="en" class="ex1_xml1.MessageBeanEnImpl" scope="prototype"></bean>
<!-- 자바에서 id 값의 bean을 호출 -->
```

scope 종류

- prototype
- request
- singleton
- session

scope를 지정해주지 않으면 singleton이 기본값으로 저장된다.

prototype으로 설정시, singleton패턴이 적용되지 않는다.



### bean 문법

```xml
<bean id='a' name='aaa' class'A'></bean>
```

- id는 다른 bean과 겹치지 않아야 한다.
- name은 'a'를 'aaa'로도 호출할 수 있게 해준다.



in Annotation 기반

```xml
<context:component-scan base-package="패키지명"/>
```

**지정한 패키지명의 하위경로의 모든 패키지 및 클래스를 조회**한다.

너무 광범위하게 지정시 느려질 수 있으므로, 필요에 따라 영역 선택을 지정하자.



.example

- POJO

```java
private B b; // b는 null

public A(B b) {
    this.b = b;
}
public setB(B b) {
    this.b = b;
}
```



- XML

```xml
<bean id='b' class='B'></bean>
<bean id='a' class='A'>
	<constructor-arg name='B' ref='b'/>
</bean>
```



- Annotation

```java
@Autowired
private B b;
```

```xml
<context:component-scan base-package="패키지명"/>
```









#### 생성자를 통한 객체 생성

```xml
<bean id="member" class="ex2_value_ref.MemberBean">
	<constructor-arg value="hong"></constructor-arg>
	<constructor-arg value="25"></constructor-arg>
	<constructor-arg value="heyheyhey"></constructor-arg>
</bean>
```

bean 객체 생성시 DTO에 해당 파라미터를 갖고 있는 **생성자가 필요**하다.



#### 프로퍼티를 통한 객체 생성

```xml
<bean id="member2" class="ex2_value_ref.MemberBean">
	<property name="name" value="hong2"></property>
	<property name="age" value="35"></property>
	<property name="message" value="heyhey"></property>
</bean>
```

프로퍼티를 통한 bean 객체 생성시 해당 name값을 지정할 **setter가 요구**되고, 기본 생성자 또한 필요하다.





## Annotation

- **Component**
- **Autowired** : 생성된 객체 전달? 주입?
- **Qualifier** : bean으로 부터 전달받을 id 값 지정
  - Qualifier를 사용하려면 반드시 Autowired가 필요하다.
  - Resource 사용시 하나로 가능하다.
- Resource





## AOP 

Aspect Oriented Programming : 관점 지향 프로그래밍





## Spring Mybatis XML 세팅

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">

    
    
	<!-- 자동 빈 생성  -->
	<context:component-scan base-package="board.impl"></context:component-scan>
    
    
	<!-- DataSource 설정 -->
	<!-- db.properties 정보를 불러옴 -->
	<context:property-placeholder location="clsspath:config/db.properties"/>
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="${jdbc.driver}"/>
	<property name="url" value="${jdbc.url}"/>
	<property name="username" value="${jdbc.username}"/>
	<property name="password" value="${jdbc.password}"/>
	</bean>
    
    
	<!-- Spring과 Mybatis 연동 설정 -->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="configlocation" value="classpath:mybatis-config.xml"/>
	</bean>

    
	<!-- DAO에 sqlSession(연결객체) 주입 -->
	<bean class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSession"></constructor-arg>
	</bean>
	<aop:aspectj-autoproxy/>
</beans>

```

