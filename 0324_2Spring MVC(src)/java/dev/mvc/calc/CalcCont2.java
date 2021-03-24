/*
0324
  ▶ CalcVO.java를 호출
 
 2. Controller 에서의 VO 사용, View에서의  parameter 접근
 ▷ /src/main/java/dev.mvc.calc.CalcCont2.java 
 - http://localhost:9090/calc/calc/add2.do?no1=100&no2=50
 
 3. calc2.jsp를 복사하여 calc_vo.jsp로 변경 후 출력
  ▷ /src/main/webapp/WEB-INF/views/calc/calc_vo.jsp 
  
  ▶ 절차 :
  - CalcVO.java(Getter와 Setter) / 
    CalcCont2.java(CalcVo로 객체 생성 하여, Getter와 Setter로 값 저장) /
    cacl_vo.jsp(CalcCont2.java의 View 부분)

  1) CalcVO.java의 setMsg으로 값 setting  + setNo1, setNo2은 GET방식 url로 값 setting
  2) setResult에 전달할 값(getNo1, getNo2) 전달
  3) calc_vo.jsp에서 EL 방식으로 출력 ex) calcVO.no1 // 객체이름.멤버변수
 */
package dev.mvc.calc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcCont2 {
  public CalcCont2() {
    System.out.println("-> CalcCont2 object created.");
  }
 
  /*
  1) 자동으로 형변환 및 값이 저장되는 경우 : CalcCont.java의 경우
 @RequestMapping(value="/calc/sub.do", method=RequestMethod.GET)
 public ModelAndView sub(int no1, int no2) {
   ModelAndView mav = new ModelAndView(); 
   mav.addObject("msg", "빼기");          
   mav.addObject("result", no1 - no2);  
   //mav.setViewName("/calc/calc1");  // /WEB-INF/views/calc/calc1.jsp
   mav.setViewName("/calc/calc2");
   return mav;
 }*/
  
  // 2) VO(DTO)객체가 생성되는 경우: calcVO 객체는 request 객체에 자동으로 저장 -> JSP view까지 값 전달
  // http://localhost:9090/calc/calc/add2.do?no1=100&no2=50
  // -> calc(패키지 이름) / calc(mapping name)
  @RequestMapping(value="/calc/add2.do", method=RequestMethod.GET) 
  public ModelAndView add2(CalcVO calcVO) { // CalcVO들의 Setter들이 호출
    ModelAndView mav = new ModelAndView();    
    calcVO.setMsg("더하기");   //  mav.addObject("msg", "더하기"); 자동실행
    calcVO.setResult(calcVO.getNo1() + calcVO.getNo2());  // Getter 받아옴
    mav.setViewName("/calc/calc_vo"); // /WEB-INF/views/calc/calc_vo.jsp
    return mav;
  }
   
}