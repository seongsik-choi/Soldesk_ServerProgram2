# 2) 서버 프로그래밍2 (구현) : (Spring/MyBATIS/Maven)  
## STS4(Spring Tool Suite4) Tree Structure  
  C:/dic/WS_FRAME/mvc  
├─.settings    <-- Eclipse에서 관리  
├─build  
│  └─classes  
│      └─mvc  <-- 컴파일된 JAVA class  
├─src  
│  └─dev.form      <-- JAVA 소스 + servlet class   
└─WebContent       <-- Web Service를 위한 dic  
    ├─form           <-- JSP  
    ├─META-INF  
    └─WEB-INF     <-- web.xml등 환경 설정 파일  
        └─lib         <-- 데이터베이스 Driver등 저장     
___ 
* JSP Model 2 방식(입력 : JSP -> 처리 : Servlet(.java)  
* 0318 : [01] servlet원리, servlet을 이용한 폼 데이터의 처리, Servlet 실습, @WebServlet 에노테이션을 이용한 Servlet 3.0 이상에서의 서블릿의 선언  
  * **JSP -> Servlet(.java file) -> compile -> .class file -> JRE -> servletObejct -> Buffer**  
  * **JSP는 실행 시 Servlet class로 변경되어 실행, 출력목적이 아닌 대부분 처리 목적(정확한 처리)**  
  * **Servlet은 자동화 문제로 불편함 Spring으로 자동화 문제 해결**
  * **Servlet code는 doGet, doPost method를 명시하여 src에 mapping**  
* 0318 :  
