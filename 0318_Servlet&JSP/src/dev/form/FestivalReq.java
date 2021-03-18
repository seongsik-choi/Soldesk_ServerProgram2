/*
 0318
 [02] Setvlet에서 JSP form으로 데이터 보내기       
  2) Servlet
    - http://localhost:9090/mvc/form/festival_req.do
    - @WebServlet 이용, STS에서 new -> Servlet -> Class name: FestivalReq
    
  - Servlet 쪽 : annoation
    @WebServlet("/form/festival_req.do")
  - JSP 쪽 : action
    <FORM name='frm' method="POST" action='/mvc/form/festival_req.do'>
  
 */
package dev.form;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// 프로젝트명은 생략(Servlet에 접근할때의 이름)
@WebServlet("/form/festival_req.seoul")     // annotation

public class FestivalReq extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override// 부모 클래스(HttpServlet)에 doGet함수가 있음
                 // HttpServletRequest와 HttpServletResponse를 모두 정의 해줘야 = @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("title", "연꽃축제");  // 키와 값의 구조
    request.setAttribute("where", "충남부여");  // 키와 값의 구조
    request.setAttribute("when", "7월 20일 ~ 7월27일");
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/form/festival_req.jsp");
    dispatcher.forward(request, response); // request, response 객체가 jsp 전달.
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println(" --> doPost");
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();

    out.println("<DIV style='width: 50%; margin: 30px auto; font-size: 26px;'>");
    out.println("[축제 참가 접수 내역]<BR><BR>");
    out.println("접수일: " + new Date().toLocaleString() + "<BR>");
    out.println("이름: " + request.getParameter("title") + "<BR>");
    out.println("지역: " + request.getParameter("where") + "<BR>");
    out.println("기간: " + request.getParameter("when") + "<BR>");
    out.println("</DIV>");
  }
 
}