/*
0324
[12] Spring MVC Annotation(@RequestParam, Form값의 자동 추출) 실습, GET/POST 방식의 분리       
 [01] Spring MVC Annotation(@RequestParam, Form값의 자동 추출) 실습, 더하기 연산

 ★1) 자동으로 형변환 및 값이 저장되는 경우 : CalcCont.java의 경우
   public ModelAndView add(int no1, int no2) { .....

  ★2) VO(DTO)객체가 생성되는 경우: calcVO 객체는 request 객체에 자동으로 저장
   public ModelAndView add(CalcVO calcVO) { .....   // jsp view까지 값을 공유!
   
 1. VO 객체의 자동 생성과 값 대입
  ▷ /src/main/java/dev.mvc.calc.CalcVO.java 

 */
package dev.mvc.calc;
 
public class CalcVO {
  private String msg;
  private int no1;
  private int no2;
  private int result;
  
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public int getResult() {
    return result;
  }
  public void setResult(int result) {
    this.result = result;
  }
  public int getNo1() {
    System.out.println("getNo1() called.");
    return no1;
  }
  public void setNo1(int no1) {
    System.out.println("setNo1() called.");    
    this.no1 = no1;
  }
  public int getNo2() {
    return no2;
  }
  public void setNo2(int no2) {
    this.no2 = no2;
  }
  
  
}