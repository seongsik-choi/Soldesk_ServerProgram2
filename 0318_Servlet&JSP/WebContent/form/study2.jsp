<%-- 
0318_JSP Model 2 방식(입력 : JSP -> 처리 : Servlet(.java)
[01] servlet원리, servlet을 이용한 폼 데이터의 처리, Servlet 실습, 
 @WebServlet 에노테이션을 이  용한 Servlet 3.0 이상에서의 서블릿의 선언

 - 정리 : Servlet은 출력 목적이 아닌 처리 목적 but 출력도 가능
             JSP보다 가벼운 실행
- 실행 순서 : JSP -> Servlet(.java file) -> compile -> .class file -> JRE -> servletObejct -> Buffer

[01] servlet원리
    1)  JSP는 실행시 서블릿 Class로 변경되어 실행
       JSP -> Tomcat(WAS:Web Application Server, Resin, JBoss...) -> Servlet JAVA code 생성
       -> compile된 class로 변경되어 JAVA JVM에서 실행

   2) WTP(Eclipse, STS)상에서의 서블릿 변환 위치: 
      /ws_frame/.metadata/.plugins/org.eclipse.wst.server.core/
    tmp0/work/Catalina/localhost/mvc/org/apache/jsp/request
         
   3) 서블릿은 class의 형태이지만 인터넷 브러우저에서 주소 입력으로 실행 가능
     - JSP보다 자바의 API를 웹에서 사용하는데 확장성이 훨씬 우수
       예) Upload/Download component, Connection Pool, 
      2D, 3D 이미지 챠트의 경우 서블릿으로 생성(but 현재는 JavaScript를 활용
    Web을 이용한 네크워크 자바 서버의 통제

     - 서블릿도 JSP 처럼 Form의 GET, POST 방식의 요청을 받아 처리가 가능
     - JSP보다 속도가 빠름
     - 단점은 Web 디자인이 어려움으로 일반적으로 화면 디자인은 JSP를 이용
     - JSP는 입출력 화면(UI) 제작용으로 사용
 
 1. Servlet Architecture
  1) javax.servlet.GenericServlet class는 서블릿관련 인터페이스를 구현하여
   서블릿 기본 초기화등 개발자의 부담을 감소시켜줍니다.
    - 선언: public abstract class GenericServlet extends java.lang.Object  implements Servlet, ServletConfig, java.io.Serializable

  2) javax.servlet.http.HttpServlet class
   - 메소드가 대부분 protected 접근 제한자라 서블릿 제작시 상속받아 doGet(), doPost()등을 구현
   - protected는 상속시에만 사용 -> 개발시에는 많이 사용 X
     
 2. 서블릿의 생명주기(약속된 메소드가 자동 실행: CallBack method)
    init() ---> service() ---> doGet(), doPost() ---> destroy()
   
       ★ Tomcat 서버에서 jsp 파일이 실행되는 경로
       ------------------------------------------------------------------
       컴파일 순서: index.jsp --> index_jsp.java --> index_jsp.class 실행
       메소드 실행 순서: _jspInit() --> _jspService() --> _jspDestroy() 
 
     - 서블릿에서 Web으로의 출력 <-> JSP는 필요 no
       response.setContentType("text/html;charset=utf-8");
       request.setCharacterEncoding("utf-8");
       PrintWriter out =  response.getWriter();
       out.println("<h2>문자열 출력</h2>");

    - service() 메소드는 GET/POST 방식을 모두 구분하지 않고 처리하는 기능,
      선언시 doGet(), doPost()가 호출되지 않습니다. 따라서 초기화 코드는 init() 메소드사용
 
    - 서블릿의 경우 부모 클래스의 메소드를 호출하면 GET/POST 방식의 기능 인식안됨
      super.doGet(request, response); // 삭제 필요
      super.doPost(req, resp);           // 삭제 필요
 
 
 3. @WebServlet 에노테이션을 이용한 서블릿의 선언
  - urlPatterns 주소 지정시 "/"부터 시작합니다. "*.do"의 경우는 "/"를 생략
 
 1) 서블릿 이름과 실행 주소가 같은 경우
    @WebServlet("Servlet1") 
    → http://localhost:9090/mvc/form/Servlet1

 2) 서블릿 이름과 실행 주소가 다른 경우
    @WebServlet(urlPatterns="/form/servlet2")
    → http://localhost:9090/mvc/form/servlet2

    @WebServlet(name="Servlet2", urlPatterns="/form/servlet2")
    → http://localhost:9090/mvc/form/servlet2
 
 3) 서블릿으로 초기값의 전달
    @WebServlet(urlPatterns="/form/servlet3", 
                     initParams = { @WebInitParam(name = "id", value = "admin1"),
                                        @WebInitParam(name = "grade", value = "AAA") })
    → http://localhost:9090/mvc/form/servlet3
 
 4) Tomcat 시작시 자동 실행되는 서블릿
   @WebServlet(urlPatterns="/form/servlet4", loadOnStartup=1)
    → http://localhost:9090/mvc/form/servlet4

 5) 모든 요청을 받는 서블릿
    @WebServlet("*.do") 
      or
    @WebServlet(name="Servlet5", urlPatterns="*.do") 
  
 [02] Servlet 실습
     - 서블릿에서 Web으로의 출력
       response.setContentType("text/html;charset=utf-8");
       request.setCharacterEncoding("utf-8");
       PrintWriter out =  response.getWriter();
       out.println("<h2>문자열 출력</h2>");

    - STS setting:
      project type: Dynamic Web Project
      project name: jsp_test
      Dynamic web module version: 3.1 ← 중요  
      JAVA: 1.8

 1. JSP 폼
 http://localhost:9090/mvc/form/study2.jsp
 
 2. 서블릿
- asyncSupported = true: 접속자 서블릿 비동기화 처리, 동기화 방식에 비해서 속도가 우수함,
                                  Thread를 직접 다룰경우는 동기화 처리가 안정적임, 생략 가능.
- private static final long serialVersionUID = 1L: RMI등의 통신에서 class를 직렬화하여 변환시
                                  동일한 클래스인지 구분하는 값, 생략 가능;
- http://localhost:9090/mvc/form/study2

  1) New -> Servlet
  -> src에 Servlet 만들어 보기(Spring은 자동화 but 자동화된 방식전에 사용했던 절차도)
  2) Class name: Study2
  3) URL mappings 설정
  4) '/form/study2'로 변경
  5) 실행 주소가 변경된 화면
  6) doGet, doPost 메소드 자동 생성
  ▷ dev.form.Study2.java
  
  tip) 실행 : JSP -> 처리 : Servlet
   -> Servlet은 정확한 처리 but 자동화 문제로 불편함 -> Spring으로 자동화 문제 해결
   
 -> Get 방식과 POST 방식의 비교 : JSP와 다르게 둘의 차이가 명확
  <form name="frm" method="GET" action="/mvc/form/study2"> 명시 필요
  <form name="frm" method="POST" action="/mvc/form/study2"
  
  -> 단점 : Servlet으로 태그와 함수를 적용해 출력을 위해서
   out.println("<DIV style='font-size: 26px; color: #FF0000; text-decoration: bold;'>");
   등의 out.println 불필요한 틀이 필요
--%>

<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html>
<html>  
<head> 
<meta charset="UTF-8"> 
<title>study2.jsp</title> 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body>
<br>
 
<!-- 서블릿의 경로를 사용할때는 프로젝트명 명시 -->
<!-- @WebServlet("/form/study2")) -->
<form name="frm" method="POST" action="/mvc/form/study2">
  현재 과목명: <input type="text" name="step" value="R" style="width:30%;"><br><br>
  다음 과목명: <input type="text" name="next" value="Python" size='25' style="width:30%;">
  <BR><BR>
  <input type="submit" value="서블릿으로 전송" />
</form>
 
</body>
</html>