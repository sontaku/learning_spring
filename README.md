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







프로젝트 구조 3가지

- Java Project -> Maven -> Spring

- Dynamic Project -> Maven -> Spring

  - 이후 톰캣 추가

  - 요청을 넘겨 받는 구조

  - index.jsp에서 "start.do" 전달

    ```jsp
    <a href="start.do">스프링을 시작합시다.</a>
    ```

  - Controller에서 매핑을 통해 전달받음

    ```java
    @Controller
    public class HelloController {
        @RequestMapping("/start.do")
        public ModelAndView start() {
            System.out.println("start.do 요청 확인");
            // 뷰페이지를 지정하고 뷰 단으로 데이터 전달
            ModelAndView mv = new ModelAndView();
            // mv.addObject("속성이름", "value");
            mv.addObject("name", "홍길동");
            mv.addObject("message", "아 졸려\n");
            mv.setViewName("/WEB-INF/view/hello.jsp");
            return mv;
        }
    }
    ```

  - ViewResolver를 통한 view 객체 전달시 Controller에서는 설정한 이름으로 view를 생성(또는 지정) 해준다.

    ```jsp
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="prefix" value="/WEB-INF/view/"/>
    	<property name="suffix" value=".jsp"/>
    </bean>
    ```

    ```java
    // 이전방식		
    // mv.setViewName("/WEB-INF/view/hello.jsp");
    mv.setViewName("hello");
    ```

- Spring Legac Project(Spring MVC Project)

  - 자동적으로 maven 변환 및 Spring이 추가되어있다.
  - java-maven-spring 순으로 생성한 프로젝트와 같은 형태지만 pom.xml의 버전은 확인해줄 필요가 있다.





```java
@Controller
@RequestMapping("/re")
public class RequestMappingController {
	@RequestMapping(value= {"/a.do", "/b.do"})
	public String test() {
		System.out.println("a.do 요청 확인");
		return "hello";
	}
	/*
	 * [중요]
	 * 	뷰페이지 지정 방식
	 * 	1) ModelAndView에 setViewName()지정
	 * 	2) 함수의 리턴형을 String인 경우
	 *		그 리턴값이 뷰페이지
	 */
	
	@RequestMapping(value="c.do")
	public void test2() {
		System.out.println("c.do 요청 확인");
	}
	
	/*
	 * [중요]
	 * 	함수의 리턴형이 void인 경우
	 * 	요청명과 동일한 뷰페이지 자동으로 지정됨
	 */
}
```





Controller와 Jsp 사이 호출

```java
@RequestMapping("request.do")
public void req(MemberVO vo) {
	System.out.println("request.do 요청");
}
```

```jsp
아이디 : ${param.id }<br/> 
이름 : ${param.name }<br/> 
나이 : ${param.age } <br/>

<!-- 권장하는 방법 -->
아이디 : ${memberVO.id }<br/> 
이름 : ${memberVO.name }<br/> 
나이 : ${memberVO.age }<br/>
```







```java
@RequestMapping("request.do")
public void req(@ModelAttribute("vo") MemberVO vo) {
	System.out.println("request.do 요청");
}
```

```jsp
아이디 : ${param.id }<br/> 
이름 : ${param.name }<br/> 
나이 : ${param.age } <br/>

아이디 : ${vo.id }<br/> 
이름 : ${vo.name }<br/> 
나이 : ${vo.age } <br/>
```





[중요] RequestMapping 되는 함수

view 페이지 지정 방식

	1. ModelAndView에 setViewName()으로 지정하고 ModelAndView 객체를 리턴
 	2. String을 리턴하면 그 리턴값이 view 페이지명
 	3. void로 리턴하면 요청명과 동일한 view 페이지 자동 지정됨

```java
// from 04_parameter.jsp
@RequestMapping("param.do")
public void param() {
	System.out.println("param.do 요청 확인");
}
/*
 * 	[중요] RequestMapping 되는 함수
 * 	view 페이지 지정 방식
 * 	1. ModelAndView에 setViewName()으로 지정하고
 * 		ModelAndView 객체를 리턴
 * 	2. String을 리턴하면 그 리턴값이 view 페이지명
 * 	3. void로 리턴하면 요청명과 동일한 view 페이지 자동 지정됨
 * 
 * 
 */
```



```java
@RequestMapping("param.do")
public void param(String id, int age) {
	System.out.println("param.do 요청 확인");
}
	
// 파라미터를 받는 경우
// 파라미터로 null 값이 들어오면 에러가 발생한다.
// 그럴 경우 아래와 같이 처리한다.


@RequestMapping("param.do")
public void param(String id, @RequestParam(defaultValue = "0") int age) {
	System.out.println("param.do 요청 확인");
}
```



## 로그인 처리(세션) in spring

```java
@RequestMapping(value = "paramForm.do", method = RequestMethod.POST)
// [중요] 로그인 세션 처리
public ModelAndView paramForm(MemberVO vo, HttpSession session) {
	System.out.println("paramForm.do 요청 확인");
		
	String id = "sontaku";
	String pw = "1234";
	if(vo.getId().equals(id) && vo.getName().equals(pw)) {
		// "login" 이라는 속성명으로 세션 저장
		session.setAttribute("login", id + "님 로그인 중");
	}
		
		
	ModelAndView mv = new ModelAndView();
	mv.setViewName("param2");
	return mv;
}
```

Controller에서 로그인시 입력받은 ID, pw 값을 세션값으로 저장하는데

이때, 받는 메소드에서는 추가 파라미터로 'HttpSession session' 를 받아와

'login' 속성명으로 저장함



```jsp
${sessionScope.login }
```

리턴받은 param2.jsp에서는 'sessionScope'를 통해 저장된 속성명으로 value값을 호출함







## [중요] 뷰페이지로 데이터 전달 방식

1. ModelAndView
2. Map(HashMap) - 잘 사용안함
3. Model



### 1. ModelAndView

```java
@RequestMapping("modelandview.do")
public ModelAndView a() {
	System.out.println("modelandview.do 전달");
	ModelAndView mv = new ModelAndView();
	mv.addObject("message", "오늘도 맛점");
	mv.addObject("addr", "버거킹");
	mv.setViewName("test");
	return mv;
}

// in test.jsp
// {message }
// {addr }
```





### 2. Map(HashMap)

```java
@RequestMapping("map.do")
public Map b() {
	System.out.println("map.do 전달");
	Map m = new HashMap();
	m.put("message", "오늘도 맛점");
	m.put("addr", "버거킹");
	// 단점 : view 페이지 지정을 못함
	// 리턴값이 Map 형태로 정해져있어 view 페이지 지정방법은
	// 자동으로 map.do -> map.jsp
	return m;
}

// in map.jsp
// {message }
// {addr }
```

자주 사용하는 방법은 아니되, 필요시 참고



### 3. Model

```java
@RequestMapping("model.do")
public String c(Model m) {
	System.out.println("model.do 전달");
	m.addAttribute("message", "오늘도 맛점");
	m.addAttribute("addr", "버거킹");
	return "test";
}

// in test.jsp
// {message }
// {addr }
```

Model 객체를 이용해서 view 페이지로 지정할 때 리턴이 아니라 인자에 지정

