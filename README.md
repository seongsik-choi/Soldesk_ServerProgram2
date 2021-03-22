# 2) 서버 프로그래밍2 (구현) : (Spring/MyBATIS/Maven)  
## STS4(Spring Tool Suite4) Tree Structure  
  C:/dic/WS_FRAME/mvc  
├─.settings    <-- Eclipse에서 관리  
├─build  
│  └─classes  
│      └─mvc  <-- 컴파일된 JAVA class  
├─src  
│  └─dev.form      <-- JAVA 소스 + Servlet  
└─WebContent       <-- Web Service를 위한 dic  
    ├─form           <-- JSP  
    ├─META-INF  
    └─WEB-INF     <-- web.xml등 환경 설정 파일  
        └─lib         <-- 데이터베이스 Driver등 저장     
___ 
* JSP Model 2 방식(입력 : JSP -> 처리 : Servlet(.java)  
* 0318 : [01] servlet원리, servlet을 이용한 폼 데이터의 처리, Servlet 실습, @WebServlet annotation을 이용한 Servlet 3.0 이상에서의 서블릿의 선언  
  * **JSP -> Servlet(.java file) -> compile -> .class file -> JRE -> servletObejct -> Buffer**  
  * **JSP는 실행 시 Servlet class로 변경되어 실행, 출력목적이 아닌 대부분 처리 목적(정확한 처리)**  
  * **Servlet은 자동화 문제로 불편함 Spring으로 자동화 문제 해결**
  * **Servlet code는 doGet, doPost method를 명시하여 src에 mapping**  
* 0318 : [02] Setvlet에서 JSP form으로 데이터 보내기
  * **setAttritube, getAttritube를 JSP 로직 숨김(Servlet으로 실행되는 것 처럼 보임)**  
___ 
* 0318 복습 + 정리  
  * Q1) Stduy2.java, FestivalReq.java가 java class 파일이지만 web상에서 실행되는 이유  
  * A1) 부모클래스인 HttpServlet에 doGet, doPost 함수가 있으며, HttpServletRequest와 HttpServletResponse  를 @Override하여 사용  
  * Q2) 서블릿은 클래스인데 실행시 웹에서 실행되려면 url을 어디에 선언?  
  * A2) @WebServlet("/form/festival_req.seoul")     // annotation(특정 기능을 갖는 선언문의 일종)  
  * Q3) private static final long serialVersionUID = 1L; 의 의미  
  * A3) 생략가능하며 서블릿 클래스의 버전을 명시, 업데이트 발생시 숫자를 증가, 선택적(생략가능)  
  * Q4) Servlet에서 GET 방식과 POST 방식을 처리하는 Method  
  * A4) DoGet Method와 DoPost Method <-> JSP는 통합하여 처리  
  * Q5) Servlet에서 출력 시 생성해야하는 객체는?  
  * A5) PrintWriter out = response.getWriter();  
  * Q6) RequestDispatcher interfacae의 사용 목적은?  
  * A6) request, response 객체를 JSP로 보내기위하여 사용  
  * Q7) request를 보내는 이유?  
  * Q7) JSP 페이지로 초기값 전달 기능  
  * Q8) Q8) request.getParmeter()를 이용하여 폼의 데이터를 가져오는것으로 아는데, Request 객체의 데이터를 저장하고 가져오는 방법은?  
  * A8) request.getParameter("title"): 폼에서 데이터 수집   
  * A8) request.setAttribute("title", "연꽃축제"): 데이터를 저장   
  * A8) request.getAttribute("title"): 저장된 데이터의 회수  
  * Q9) 서블릿의 사용 목적?  
  * A9) Web에서의 데이터 처리, JSP도 서버에서 서블릿으로 변경되어 실행  
  * Q10) 서블릿 실행시 GET방식이 호출되는 이유는? 
  * A10) http://localhost:9090/mvc/form/study2 주소가 브러우저에 입력되어 실행되기 때문에 GET 방식으로처리 + GET 방식(Broswer에 주소를 입력) +POST방식(form에서 진행)  

* 0319 : [03] JSP Model 2(MVC) 개론, Model/JSP View가 결합된 MVC Controller version 1.0   
* 0319 : [04] JSP View가 분리된 MVC Controller version 2.0 실습(Servlet(Controller)<->JSP(View)  
  * **ex)Controller2ex.java(Controller) & view2ex.jsp(View)로 나뉘는 MVC 2.0 예제**  
___ 
* 0320 : 
  * .jsp Model1 : form.jsp -> proc.jsp -> beans.java : model1은 디자인과 처리과 섞여있어 복잡(한사람이 여러 작업하는 꼴)  
  * .jsp Model2(MVC) : Controller3.java의 doGet() -> form.jsp -> post submit -> Controller3.java의 doPost() -> Beans -> proc.jsp  
  * Controller3Model.java의 request 객체 = doPost()의 request 객체  
  * doPost()의 request 객체 = setData()의 request 객체는 결국 같은 메모리, Return이 필요 NO  
* 0320 :  
* 
