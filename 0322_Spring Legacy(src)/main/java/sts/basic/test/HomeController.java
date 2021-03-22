/*
0323
[06] Maven, Spring기반 MVC의 원리, STS Spring MVC의 개발 구조 분석, Spring 4.3.23~26 설정, JDK 1.8.0, Servlet 3.1 설정, Spring  Tools 3 Add-On 설치 ★    

[01] Spring framework 기반 project 원리
  - 흐름 : JAVA -> JSP -> MVC -> Spring Legacy(Spring 구형 개발~18년도) -> Spring Boot(Spring 개발 2019~)
 
  - framework : 특정 언어를 이용하여 개발하는 방법론을 결정하고 그 절차를 따라 개발할수 있도록
             구성이 이루어진 프로그램 소스의 집합(Python ; package)
  - library: 데이터베이스 연결 해제등 특정 기능을 자동화한 자바 소스이며 framework보다 규모가 작음
         (Python: package)

1. 기본 구조    
     - Model: DAO, Manager(Process), DTO(VO), 데이터 처리 클래스등 
     - View: HTML, CSS, JS, jQuery, Vue.js, JSP, EL, JSTL, Thymeleaf 
     - Controller(Action): Spring에서 지원 하는 Controller사용 
       . MVC에서 사용되는 Controller Servlet은 Spring이 자동으로 지원해줌으로,
         개발자는 GET/POST 요청에 따른 관련 모델(DAO, VO...)을 호출하고 View(JSP)로 이동하는
         class를 주로 개발.

     - 용어의 변경 
        MVC Controller -+-> Spring Front Controller(자동 지원, 주소 분할 처리) 
                                |
                                +-> Spring Controller (개발자 구현, GET, POST 요청 처리) 
                                       ------------------------------------------------------------   
                                                 AddCont.java (GET/POST방식 처리)               

 ▶ 개발자가 알아야하는 Spring 핵심 루틴
  ① Request : Chrome에서 주소 입력 후 요청 -> Dispacter Servlet : 사용자의 요청을 받음
  ② HanlerMapping : GET or POST 방식의 구분하여 해당하는 메소드등을 검색
  ③ Controller : 개발자가 제작한 메소드 실행, request에 출력 데이터 저장
  ④ Model : DBMS등에 접속하여 데이터 처리
  ⑤ View : Model의 처리 결과를 출력, Dispacter Sevlet이 최종 출력할 View JSP를 결정
  ⑥ 최종적으로 : JSP or HTML이 출력

------------------------------------------------------------------------------------------
[02] Maven 의존성 추가( : library : .jar 파일)
 - jar : java class가 압축된 파일
 - http://mvnrepository.com
 - 일반적으로 드라이버등 필요한 라이브러리가 있을 경우 jar 파일을 인터넷에서 다운받아,
  압축을 풀어 '/WEB-INF/lib' 폴더에 복사해서 사용.
  하지만 Maven은 직접 다운을 개발자가 받지않고 'pom.xml'에, 필요한 JAR 라이브러리관련
  선언만으로 자동 다운로드되어 사용할 수 있는 환경을 제공 
  . Window10: C:/Users/STU/.m2 
   

 - 프로젝트의 '/Maven Dependencies'폴더를 보면 자동으로 다운로드된 라이브러가 저장
 - 'pom.xml' 파일의 XML문을 지우면 jar 파일이 자동으로 삭제 
 - 인터넷의 문제로 다운로드가 안되면 '/WEB-INF/lib' 폴더에 jar 파일을 직접 저장가능
    
 1. Maven MySQL, Oracle 드라이버(기능을 사용하게 해주는 소스)의 의존성 추가 예 
   - http://mvnrepository.com -> Spring 에서 의존성 추가 
     예)
     <dependency>
       <groupId>mysql</groupId>                            ← 기업 이름
       <artifactId>mysql-connector-java</artifactId> ← 제품명
       <version>5.1.38</version>                ← 버전명
       <scope>compile</scope>               ← library가 추가되는 형태, 생략 가능
     </dependency>

  - scope: library 사용범위
    .compile: 기본값으로 컴파일시에 사용되고 프로젝트에 포함되며 배포됨 예) Oracle JDBC, DBCP Pool
    .provieded: 실행시에 외부(Tomcat, JAVA)로부터 제공받아 실행, 예) servlet, jsp, JDK 

------------------------------------------------------------------------------------------
[03] Spring MVC Web Project의 실습 
- Spring Legacy를 사용하진 않지만 + 실습해볼 필요! : 배포된 StS는 이미 설치돼있음.

<설치돼 있기에 생략>
1) STS3 plugin의 설치
① STS -> Help -> Eclipse Marketplace...
② "sts3" 검색
③ 'Spring Tools 3 Add-On for spring Tools 4' 설치
* 설치 에러 발생시 STS를 최신 버전으로 변경 할 것 ★
  STS 4.6.0 -> Spring Tools 3 Add-On for Spring Tools 4 3.9.13.RELEASE
  STS 4.8.0 -> Spring Tools 3 Add-On for Spring Tools 4 3.9.14.RELEASE
④ STS 재시작

1. Project Type: Spring Legacy Project(Spring Project) -> Spring MVC Project    
           Name: sts_basic 
        Package: sts.basic.test   <- 3단 이상 패키지 설정, 공백 있으면 안됨. 
              test: ContextPath = request.getContextPath(), 마지막 패키지 이름을 사용함으로
                    설정에 주의
                    (Eclipse 개발시 JSP 프로젝트는 프로젝트 이름을 사용: sts_basic)  
        Library: 프로젝트 생성시 관련 Spring 라이브러리가 자동으로 다운로드  
                 됩니다. 작업 컴퓨터는 인터넷에 연결되어 있어야 
                 (Spring MVC 프로젝트 생성시 최초에 약 16 MB 정도 자동 다운로드.)

 1) 프로젝트 생성시 인터넷에 연결이되어 있어야 
    'New -> Spring Legacy Project'
  
 2) Project Name: sts_basic
   Templates: Spring MVC Project
  
 3) 관련 library를 계정과 관련된 기본 폴더로 다운로드

 4) 패키지 설정 : 3단으로 작성해주기(a.a.a), 마지막 테스트명은 = 프로젝트 명
   - Enter a topLevelPackage: sts.basic.test
   - "sts.basic.test" 중에서 마지막 패키지 이름 'test'가 프로젝트 접근에 사용되는
     Root ContextPath으로 사용
     예) http://localhost:9090/sts_basic/member/login.do(JSP 방식)  X
       http://localhost:9090/test/member/login.do(Legacy 방식)        O
     프로젝트 이름 'sts_basic'은 STS 개발툴에서 프로젝트 이름으로만 사용
 -> Spring Boot의 경우 : http://localhost:9090/member/login.do      (프로젝트명도 사용 no)

    
 5) 관련 jar library의 자동 다운로드, 윈도우 계정별로 다를 수 있음, 최초 프로젝트 생성시만 3분 소요
 C:/Users/tonny/.m2/repository
  
------------------------------------------------------------------------------------------
[참고 : Legacy 사용시 기본설정등의 복잡함을 의미] JDK 1.8, Sping 4.3.23 ~ 4.3.26 version 설정
 - 4.3.23 Tomcat 실행 안되는 버그 존재
 - Interceptor, JUnit등을 실행할 경우 원활한 수업을 위해 Spring을 4.3.23 ~ 4.3.26으로 변경

 1) pom.xml 버전 변경: JAVA 1.8, Spring 4.3.23.RELEASE ~ 4.3.26.RELEASE 로 지정
 - 'C:/Users/tonny/.m2/repository/org/springframework/spring-aop' 변경된 버전의 확인
 <properties>
<java-version>1.8</java-version>  ◀ 11번 라인
<org.springframework-version>4.3.26.RELEASE</org.springframework-version> ◀ 12번 라인
<org.aspectj-version>1.6.10</org.aspectj-version>
<org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
  
2) servlet 3.1 기반으로 변경
    <!- Servlet ->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId> ◀ 96번 라인
      <version>3.1.0</version> ◀ 97번 라인
    </dependency>
 
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.2</version> ◀ 103번 라인
    </dependency>
 
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
 
    <!- Test ->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version> ◀ 116번 라인
      <scope>test</scope>
    </dependency>
 
3) Maven compile 1.8로 버전 변경
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.5.1</version>
                <configuration>
                    <source>1.8</source> ◀ 141번 라인
                    <target>1.8</target>  ◀ 142번 라인
                    <compilerArgument>-Xlint:all</compilerArgument>
                    <showWarnings>true</showWarnings>
                    <showDeprecation>true</showDeprecation>
                </configuration>
            </plugin>
   
4) 프로젝트 환경 변경 순서
5) 자바 컴파일러 JDK 1.8로 변경
6) 실행시 자바 호환 버전 JDK 1.8로 변경
7) JDK 1.8로 변경
   - 프로젝트 선택 -> Properties... -> Project Facets -> Java -> Version 1.8
[에러 처리]   
1. pom.xml 에러
   - 프로젝트에 에러가 사리지지않으면 스프링의 버전을 변경
2. 메이븐을 다시 업데이트
   1) Project 선택 -> Maven -> Update Project...
------------------------------------------------------------------------------------------
[07] STS Spring project 구조       
[01] Controller 
   - 프로젝트를 만들면 sample 코드인 'HomeController.java' 파일이 생성돼 있음
   - JSP Servlet: @WebServlet(urlPatterns = "/controller3/tot.do3"), doGet()..., doPost()...
   - Spring: @RequestMapping(value = "/controller3/tot.do3", method = RequestMethod.GET)
   ★ 실행 주소: http://localhost:9090/test/ 실행 주소는 '프로젝트 이름과 상관이 없고'
     사용된 자바의 '마지막 패키지 이름'을 프로젝트 이름으로 사용★
   -> http://220.121.148.7:9090/test/

1) 프로젝트 생성시 초기 구성 
   └─/sts_basic/src/main/java                 : Java class 저장 폴더 
   └─/sts_basic/src/main/webapp             : Eclipse의 WebContent와 동일 기능 
   └─/sts_basic/src/main/webapp/resources     : CSS, JS, Image등의 리소스 저장 폴더
   └─/sts_basic/src/main/webapp/WEB-INF       : Web 환경 설정 XML  
   └─/sts_basic/src/main/webapp/WEB-INF/spring  : Spring 환경 설정 XML 
   └─/sts_basic/src/main/webapp/WEB-INF/views   : JSP file 저장 폴더
 
 예) sts_basic 프로젝트의 경우
     sts.basic.test -> request.getContextPath() -> test

    * 패키지의 마지막 패키지가 프로젝트명으로 사용
     기존에 test 프로젝트가 있으면 Tomcat이 작동하지 않음으로 삭제
  
  Q) return 시 
  -> return "home";        // /WEB-INF/views/home.jsp
  
  2. View  : JSP와 MVC와 다르게 WEB-INF dic는 웹상 보안유지
   - 프로젝트를 만들면 기본적으로 아래의 JSP 파일이 됨
   - 한글 엔코딩을 위해 JSP 파일 최상단에 아래의 코드를 추가 
   <%@ page contentType="text/html; charset=UTF-8" %> 
 1) 기본적으로 생성된 JSP View
    ▷ /sts_basic/src/main/webapp/WEB-INF/views/home.jsp 
  A) .jsp는 단독으로 실행시킬 수 없음
  A) 보안성 Up but 개발자는 불편
 
 2) 추가된 JSP View 
- HomeController.java 변경, 'spring.jsp' 설정
  return "spring";  // <-> String view = "/controller4/form.jsp";를 의미 + dispacther 사용 no
 ▷ /sts_basic/src/main/webapp/WEB-INF/views/spring.jsp 

 3. 자동으로 생성된 Web Project 환경 설정 파일 
  1) web.xml
 
  2) 자동으로 생성된 Spring 환경 설정 파일 
   ▷ /sts_basic/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 
 
 4. 실행 
 1) 프로젝트 생성시 마지막 패키지 이름이 Root ContextPath으로 지정,
    - 프로젝트를 선택하고 'Run As --> Run on Server'를 선택
 
   Package: sts.basic.test 
   URL: http://localhost:9090/test/       <- GET 
  
 5. 실행 주소의 변경 
 1) HomeController.java 25 번 라인 변경, '/' --> '/hello' 
   @RequestMapping(value = "/hello", method = RequestMethod.GET) 
   최종 주소 : http://localhost:9090/test/hello

 2) HomeController.java 25 번 라인 변경, '/hello' -> '/hello.do' 
   @RequestMapping(value = "/hello.do", method = RequestMethod.GET) 
   최종 주소 : http://localhost:9090/test/hello.do
    
 6. /sts_basic/src/main/webapp/WEB-INF/views/home.jsp 변경
 - <%@ page session="false" %>: Session 객체 사용 안함.   
 */
package sts.basic.test;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";        // /WEB-INF/views/home.jsp
		                               // <-> String view = "/controller4/form.jsp";를 의미 + dispacther 사용 no
	  //return "spring";    // /WEB-INF/views/spring.jsp
	}
	
}
