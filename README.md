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
* **0318 : [01] servlet원리, servlet을 이용한 폼 데이터의 처리, Servlet 실습, @WebServlet annotation을 이용한 Servlet 3.0 이상에서의 서블릿의 선언**  
  * ▶ **JSP -> Servlet(.java file) -> compile -> .class file -> JRE -> servletObejct -> Buffer**
  * ① JSP는 실행 시 Servlet class로 변경되어 실행, 출력목적이 아닌 대부분 처리 목적(정확한 처리)  
  * ② Servlet은 자동화 문제로 불편함 Spring으로 자동화 문제 해결  
  * ③ Servlet code는 doGet, doPost method를 명시하여 src에 mapping  
* **0318 : [02] Setvlet에서 JSP form으로 데이터 보내기**
  * ▶ setAttritube, getAttritube를 JSP 로직 숨김(Servlet으로 실행되는 것 처럼 보임)  
___ 
* **0318 복습 + 정리**
  * ▶ Stduy2.java, FestivalReq.java가 java class 파일이지만 web상에서 실행되는 이유  
  * A1) 부모클래스인 HttpServlet에 doGet, doPost 함수가 있으며, HttpServletRequest와 HttpServletResponse  를 @Override하여 사용  
  * ▶ 서블릿은 클래스인데 실행시 웹에서 실행되려면 url을 어디에 선언?  
  * A2) @WebServlet("/form/festival_req.seoul")     // annotation(특정 기능을 갖는 선언문의 일종)  
  * ▶ private static final long serialVersionUID = 1L; 의 의미  
  * A3) 생략가능하며 서블릿 클래스의 버전을 명시, 업데이트 발생시 숫자를 증가, 선택적(생략가능)  
  * ▶ Servlet에서 GET 방식과 POST 방식을 처리하는 Method  
  * A4) DoGet Method와 DoPost Method <-> JSP는 통합하여 처리  
  * ▶ Servlet에서 출력 시 생성해야하는 객체는?  
  * A5) PrintWriter out = response.getWriter();  
  * ▶ RequestDispatcher interfacae의 사용 목적은?  
  * A6) request, response 객체를 JSP로 보내기위하여 사용  
  * ▶ request를 보내는 이유?  
  * Q7) JSP 페이지로 초기값 전달 기능  
  * ▶ request.getParmeter()를 이용하여 폼의 데이터를 가져오는것으로 아는데, Request 객체의 데이터를 저장하고 가져오는 방법은?  
  * A8) request.getParameter("title"): 폼에서 데이터 수집   
  * A8) request.setAttribute("title", "연꽃축제"): 데이터를 저장   
  * A8) request.getAttribute("title"): 저장된 데이터의 회수  
  * ▶ 서블릿의 사용 목적?  
  * A9) Web에서의 데이터 처리, JSP도 서버에서 서블릿으로 변경되어 실행  
  * ▶ 서블릿 실행시 GET방식이 호출되는 이유는? 
  * A10) http://localhost:9090/mvc/form/study2 주소가 브러우저에 입력되어 실행되기 때문에 GET 방식으로처리 + GET 방식(Broswer에 주소를 입력) +POST방식(form에서 진행)
* **0319 : [03] JSP Model 2(MVC) 개론, Model/JSP View가 결합된 MVC Controller version 1.0**
* **0319 : [04] JSP View가 분리된 MVC Controller version 2.0 실습(Servlet(Controller)<->JSP(View)**
  * **▶ex)Controller2ex.java(Controller) & view2ex.jsp(View)로 나뉘는 MVC 2.0 예제**  
___ 
* **0322 : [05] Model, JSP View가 분리된 MVC Controller version 3.0 실습**
  * ▶jsp Model1 : form.jsp -> proc.jsp -> beans.java : model1은 디자인과 처리과 섞여있어 복잡(한사람이 여러 작업하는 꼴)  
  * ▶jsp Model2(MVC) : Controller3.java의 doGet() -> form.jsp -> post submit -> Controller3.java의 doPost() -> Beans -> proc.jsp
  * **▶ex)Controller3.java & Controller3Model.java & form, proc.jsp 로 나뉘는 MVC 2.0 예제**  
  * **▶Call By Reference : 주기억 장치에 있는 Memory 공유**    
  * ① Controller3Model.java의 request 객체 = doPost()의 request 객체  
  * ② doPost()의 request 객체 = setData()의 request 객체는 결국 같은 메모리, Call By Reference(Return이 필요 NO)   
___ 
## STS4(Spring Tool Suite4) Tree Structure : Spring Legacy  
  C:/dic/WS_FRAME/sts_basic    
├─.settings    <-- Eclipse에서 관리  
├─Spring Elements  
├─Java Resources(src)  
   └─src/main/java/sts/basic/test      <-- JAVA class 파일  
   └─src/main/webapp             : ★Eclipse의 WebContent와 동일 기능, JSP의 단독 실행 가능★    
   └─src/main/webapp/resources     : CSS, JS, Image등의 리소스 저장 폴더  
   └─src/main/webapp/WEB-INF       : Web 환경 설정 XML + 실행시 spring이 반드시 필요  
   └─src/main/webapp/WEB-INF/spring  : Spring 환경 설정 XML  
         └─servlet-context.xml  
	     └─<context:component-scan base-package="dev.mvc.cal2" /> : 다른 패키지 추가(Defence injection) 
   └─src/main/webapp/WEB-INF/views   : ★JSP file 저장 폴더, JSP의 단독 실행 불가능★ 
___ 
* **0322 : [06] Maven, Spring기반 MVC의 원리, STS Spring MVC의 개발 구조 분석, Spring 4.3.23~26 설정, JDK 1.8.0, Servlet 3.1 설정, Spring  Tools 3 Add-On 설치 ★**
  * **▶흐름 : JAVA -> JSP -> MVC -> Spring Legacy(Spring 구형 개발-18년도) -> Spring Boot(Spring 개발 2019-)**  
  * **▶ 개발자가 알아야하는 Spring 핵심 루틴**  
  * ① Request : Chrome에서 주소 입력 후 요청 -> Dispacter Servlet : 사용자의 요청을 받음  
  * ② HanlerMapping : GET or POST 방식의 구분하여 해당하는 메소드등을 검색  
  * ③ Controller : 개발자가 제작한 메소드 실행, request에 출력 데이터 저장  
  * ④ Model : DBMS등에 접속하여 데이터 처리  
  * ⑤ View : Model의 처리 결과를 출력, Dispacter Sevlet이 최종 출력할 View JSP를 결정  
  * ⑥ 최종적으로 : JSP or HTML이 출력  
* **0322 : [07] STS Spring project 구조**  
* **0322 : [08][과제] sts_env STS Spring project 생성 실습**  
___ 
* **0323 : [09] EL(표현 언어, Expression Language)**
  * **▶ JSP의 단점 : Scriptlet의 사용**
  * ① 보안문제(웹 상 JAVA Code  노출) : ex) JAVA코드 오류시 코드노출 + 주석노출
  * **▶ Context Path: <%=request.getContextPath()   -> 출력 ->ContextPath: /test**
  * ① 패키지명 출력 (Legacy는 ex)sts.basic.test일 경우, 3번째 프로젝트명 사용)
  * **▶JSP와 EL의 사용 차이(request 객체의 호출 차이)**
  * ① JSP : request.getAttribute("name")      ==  EL : ${requestScope.name} or ${name}
  * ② JSP : request.getParameter("money") == EL : ${param.money}
  * ③ JSP : 생성된객체.getMovie()             == EL : ${dto.movie }
  * ④ JSP : request.setAttribute("no1", 100); -> int no1 = (Integer)request.getAttribute("no1"); // Object형 -> Int형 형변환
  * **▶ ex)exam1.jsp(Get방식의 getParameter 사용) / exam2.jsp(Post방식의 Set,getAttritube 사용)**
* **0323 : [10] Spring MVC Annotation(@Controller, @RequestMapping) 실습, 더하기 연산**
  * **▶ Spring Legacy Project -> Spring Legacy Project 생성 : sts_calc / dev.mvc.calc** 
  * **▶ ex) CallcCont.java(Controller(Action) 구현) / calc1.jsp(View 구현)** 
~~~
// CallcCont.java
package dev.mvc.calc; // add method와 sub method 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcCont {
  public CalcCont() {
    System.out.println("-> CalcCont object created.");
  }
  
  // 1) http://localhost:9090/calc/calc/add.do?no1=100&no2=50   -> calc(패키지 이름) / calc(mapping name)
  // 2) Spring DispatcherServlet이 Web 요청을 받음(web.xml에 선언)
  // 3) Spring Handler Mapping: Controller에서 일치하는 주소를 검색, 전송 method 확인
  @RequestMapping(value="/calc/add.do", method=RequestMethod.GET) 
  public ModelAndView add(int no1, int no2) {   // 4) Controller의 method() 실행
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "더하기");           // 5)  ==request.setAttritube("msg", "더하기");
    mav.addObject("result", no1 +no2);   
    
     /* /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
    해당 주석 2line은 servlet-context.xml의 구문  : ModelAndView 준비하여 jsp 파일명 및 데이터 저장
    <beans:property name="prefix" value="/WEB-INF/views/" />
    <beans:property name="suffix" value=".jsp" /> */
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
    
    /* 6) Spring DispatcherServlet이 주어진 jsp 페이지로 request, response객체를 forward
     개발자가 선언하지 않아도 자동 forward : HandlerMapping이라 부름 
     -> 해당 2 line을 HandlerMapping으로 자동화!
     RequestDispatcher dispatcher = request.getRequestDispatcher("/form/a.jsp"); // .jsp 호출
     dispatcher.forward(request, response); // request, response 객체가 jsp 전달. */
  }
  
  // http://localhost:9090/calc/calc/sub.do?no1=100&no2=50
  @RequestMapping(value="/calc/sub.do", method=RequestMethod.GET)
  public ModelAndView sub(int no1, int no2) {
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "빼기");          
    mav.addObject("result", no1 - no2);  
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
  }
}
~~~
~~~
<%--
/webapp/WEB-INF/views/calc/calc1.jsp
Scriptlet 방식과 EL 방식의 처리
--%>
<DIV class='container'>
<DIV class='content'>

  <H1>계산기(Scriptlet calc1.jsp)</H1>
  <%= request.getAttribute("msg")%> 계산기<br>	<!-- setAttritube(addObject) -->
  수1: <%=request.getParameter("no1") %><br>	<!--  getParameter : url로 입력 ?no1=100&no2=50-->
  수2: <%=request.getParameter("no2") %><br>
  결과: <%= request.getAttribute("result")%> <br><br> <!-- setAttritube(addObject) -->

  <H1>계산기(EL calc1.jsp)</H1>
  계산기 ${msg }<br>        <!-- setAttritube(addObject) -->
  수1: ${param.no1 }<br> <!--  getParameter : url로 입력 ?no1=100&no2=50-->
  수2: ${param.no2 }<br>
  결과: ${requestScope.result }<br><br> <!-- requestScope.result == result  -->

</DIV> <!-- content END -->
</DIV> <!-- container END -->
~~~
  * **▶** 
  * ①  
___ 
* **0324 : [11] Spring MVC Annotation(@RequestParam, Form값의 자동 추출) 실습, GET/POST 방식의 분리**
* **0324 : **