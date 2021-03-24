package dev.mvc.calc;
 
public class CalcVO {
  private String msg;
  private int no1;
  private int no2;
  private int result;
  
  public CalcVO() { // source -> 기본 생성자
    
  }

  public CalcVO(String msg, int no1, int no2, int result) { // source -> 매개변수 생성자
    this.msg = msg;
    this.no1 = no1;
    this.no2 = no2;
    this.result = result;
  }

  @Override
  public String toString() { // source -> 값 전달 확인
    return "CalcVO [msg=" + msg + ", no1=" + no1 + ", no2=" + no2 + ", result=" + result + "]";
  }

  public String getMsg() { // source -> getter/Setter
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getNo1() {
    return no1;
  }

  public void setNo1(int no1) {
    this.no1 = no1;
  }

  public int getNo2() {
    return no2;
  }

  public void setNo2(int no2) {
    this.no2 = no2;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
  
  
}