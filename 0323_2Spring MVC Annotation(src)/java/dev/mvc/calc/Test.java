/*
0323
[10] Spring MVC Annotation(@Controller, @RequestMapping) 실습, 더하기 연산
 [01] Spring MVC Annotation(@Controller, @RequestMapping) 실습, 더하기 연산

1. Project Type: Spring Legacy Project(Spring Project) -> Spring MVC Project    
        Name: sts_calc 
        Package: dev.mvc.calc  ← 3단 이상 패키지 설정  
        ContextPath: calc        ← 마지막 패키지 이름을 사용, URL 입력
        Library: 프로젝트 생성시 관련 Spring 라이브러리가 자동으로 다운로드  
                  됩니다. 작업 컴퓨터는 인터넷에 연결되어 있어야

 2. 자동 생성 되어 있는 환경 설정 파일
 ▷ /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
 1) XML
   - 표준은 W3C에서 제정.
   - HTML과는 다르게 태그를 특정 SW, 기업이나 단체에서 제작 가능
   - 최상위 root 태그는 하나만 존재해야합니다. HTML의 최상위 태그는 <HTML>
   - HTML은 대소문자를 구분하지 않으나 XML은 대소문자를 구분 
   - XML은 데이터보다 환경 설정 파일이나 GUI 구성 파일로 사용
   - JSP는 환경 설정 파일을 XML에서Annotation으로 변경해가고 있습니다. 예) @WebServlet

3. 객체의 자동 생성 패키지 선언
   - 스프링은 서버 시작시 @ Annotation 선언된 빈을 자동으로 생성하고 실행 상태에 진입
     DI(Dependency Injection)가 자동 지원
     <context:component-scan base-package="sts.mvc.calc" />

   - @Controller Annotation이 선언된 클래스를 자동 생성됩니다.
      Servlet 유형 1: <load-on-startup>1</load-on-startup>
      Servlet 유형 2: @WebServlet(urlPatterns = {"*.do2"}, loadOnStartup = 3)
 
   - 자동으로 생성되는 빈(객체)의 형태: 첫자가 소문자로 변환되어 객체명으로 쓰임.
     AddCont addCont = new AddCont(); 자동 실행되어 addCont 객체 생성
 
 1) @Controller 에노테이션이 붙은 클래스 객체 자동 생성
 - Test test = new Test() 자동 실행
 - 실행: sts_calc -> Run As -> Run on Server
  [Console]
  -> test 객체 생성됨.
   ▷ /src/main/java/dev.mvc.calc.Test.java 

 */
package dev.mvc.calc;
import org.springframework.stereotype.Controller;
 
@Controller   
// @Controller 에노테이션이 붙은 클래스 객체 자동 생성 -> 사용자 요청 받음
public class Test {
  public Test(){
    System.out.println("--> test 객체 생성됨.");
  }
}
 