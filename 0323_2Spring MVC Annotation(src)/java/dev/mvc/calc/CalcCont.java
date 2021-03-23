/*
0323
4. Controller(Action) 구현

 1) ModelAndView: 최종 결과를 출력할 JSP 파일명과 출력할 데이터를 가지고 있는 클래스
    - JSP 출력시 파일명이 자동 조합
       servlet-context.xml에따라 접두사와 접미사가 자동 결합니다.
      <beans:property name="prefix" value="/WEB-INF/views" />
      <beans:property name="suffix" value=".jsp" />
      예) mav.setViewName("/calc/add");   ← /WEB-INF/views/calc/add.jsp
           mav.setViewName("/pds/create");   ← /WEB-INF/views/pds/create.jsp
           mav.setViewName("/pds/list");   ← /WEB-INF/views/pds/list.jsp
 
 2) JSP로 전달할 데이터의 저장, forward action 태그 기능 자동 실행 
   - Servlet: request.setAttribute("no1", no1)
   - Spring: mav.addObject("no1", no1)
 
   - Forward 자동 지원: request, response 객체를 계속 가지고 이동
     RequestDispatcher dispatcher = request.getRequestDispatcher(view);
     dispatcher.forward(request, response);
     Spring은 자동 지원.    
 
 3) @Controller: 접속자의 URL 요청을 처리 선언, GET, POST 요청 처리 

 4) 실행 주소의 자동 추출
   @RequestMapping(value="/calc/add.do", method=RequestMethod.GET)
   - 사용자가 입력한 URL에서 ContextPath(프로젝트 실행 이름)을 제외한 URI를 추출
    ex)
     http://localhost:9090/calc/calc/add.do?no1=100&no2=50 
     --> /calc/add.do: 프로젝트명을 제외한 순수한 폴더와 파일명만 자동 추출됨
  
  ▶ public ModelAndView add(int no1, int no2) { } 
  A) addObject = setAttritube
  
  [Web 실행 화면]
  http://localhost:9090/calc/calc/add.do?no1=100&no2=50 
 */
package dev.mvc.calc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcCont {
  public CalcCont() {
    System.out.println("-> CalcCont object created.");
  }
  
  // ① http://localhost:9090/calc/calc/add.do?no1=100&no2=50   -> calc(패키지 이름) / calc(mapping name)
  // ② Spring DispatcherServlet이 Web 요청을 받음(web.xml에 선언)
  // ③ Spring Handler Mapping: Controller에서 일치하는 주소를 검색, 전송 method 확인
  @RequestMapping(value="/calc/add.do", method=RequestMethod.GET) 
  public ModelAndView add(int no1, int no2) {   // ④ Controller의 method() 실행
    ModelAndView mav = new ModelAndView(); // 
    mav.addObject("msg", "더하기");           // ⑤  ==request.setAttritube("msg", "더하기");
    mav.addObject("result", no1 +no2);   
    
    // /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
    // 해당 주석 2line은 servlet-context.xml의 구문  : ModelAndView 준비하여 jsp 파일명 및 데이터 저장
    // <beans:property name="prefix" value="/WEB-INF/views/" />
    // <beans:property name="suffix" value=".jsp" />
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
    
    // ⑥ Spring DispatcherServlet이 주어진 jsp 페이지로 request, response객체를 forward
    // 개발자가 선언하지 않아도 자동 forward
  }
  
  //http://localhost:9090/calc/calc/sub.do?no1=100&no2=50
  @RequestMapping(value="/calc/sub.do", method=RequestMethod.GET)
  public ModelAndView sub(int no1, int no2) {
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "빼기");          
    mav.addObject("result", no1 - no2);  
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
  }
  
  //http://localhost:9090/calc/calc/sub.do?no1=100&no2=50
  @RequestMapping(value="/calc/mul.do", method=RequestMethod.GET)
  public ModelAndView mul(int no1, int no2) {
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "곱하기");          
    mav.addObject("result", no1 * no2);  
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
  }
  
  //http://localhost:9090/calc/calc/sub.do?no1=100&no2=50
  @RequestMapping(value="/calc/div.do", method=RequestMethod.GET)
  public ModelAndView div(int no1, int no2) {
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "나누기");          
    mav.addObject("result", no1 / no2);  
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
  }
  
  //http://localhost:9090/calc/calc/sub.do?no1=100&no2=50
  @RequestMapping(value="/calc/mod.do", method=RequestMethod.GET)
  public ModelAndView mod(int no1, int no2) {
    ModelAndView mav = new ModelAndView(); 
    mav.addObject("msg", "나머지");          
    mav.addObject("result", no1 % no2);  
    mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
    return mav;
  }
 
  
}