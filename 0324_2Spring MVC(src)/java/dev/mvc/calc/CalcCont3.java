/*
0324
[02] Controller에서의 GET, POST 분리
1. View: JSP 
 1) Form
  - Controller 주소: @RequestMapping(value="/adder/tot.do", method=RequestMethod.POST)
  - 실행 주소: http://localhost:9090/calc/adder/tot.do <-- Context Path 선언
  - FORM action 주소: <form name='frm' method='post' action="/calc/adder/tot.do"> <-- Context Path 선언
 
 2. Controller 분리
 - method=RequestMethod.GET  : tot_form.jsp
   method=RequestMethod.POST : tot_proc.jsp
 
 [실행 화면]
 수1 [ 1 ]   ← Controller가 request 객체에 보낸 값 출력
 수2 [ 10 ]  ← Controller가 request 객체에 보낸 값 출력
 [합계]
 */
package dev.mvc.calc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcCont3 {
  public CalcCont3() {
    System.out.println("-> CalcCont3 object created.");
  }
 
  // 1) Get방식의 출력 : tot_form.jsp 호출
  // http://localhost:9090/calc/calc/add3.do -> calc(패키지 이름) / calc(mapping name)
 @RequestMapping(value="/calc/add3.do", method=RequestMethod.GET) 
  public ModelAndView add3() {
    ModelAndView mav = new ModelAndView();    
    mav.addObject("no1", 1000);
    mav.addObject("no2", 2000);
    mav.setViewName("/calc/tot_form"); // /Web-INF/views/calc/tot_form.jsp
    return mav;
  }
 
 // 2) POST 방식의 처리 : tot_proc.jsp 호출(처리페이지)
 @RequestMapping(value="/calc/add3.do", method=RequestMethod.POST) 
  public ModelAndView add3(CalcVO calcVO) {
    ModelAndView mav = new ModelAndView();    
    calcVO.setMsg("더하기");   //  mav.addObject("msg", "더하기"); 자동실행
    calcVO.setResult(calcVO.getNo1() + calcVO.getNo2());  // Getter 받아옴
    mav.setViewName("/calc/tot_proc"); // /Web-INF/views/calc/tot_form.jsp
    return mav;
  }
}