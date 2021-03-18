/*
 0318_JSP Model 2 방식(입력 : JSP -> 처리 : Servlet(.java)
 study2.jsp가 실행될 때 변환되는 Servlet을 의미
 
 -> annotation : annotaion 을 사용하면 web.xml에 등록하지 않아도 서블릿 클래스로 연결
  
 -> Servlet을 출력하기 위한 문장(doGet, doPost 메소드에 명시)
      response.setContentType("text/html;charset=utf-8");
       request.setCharacterEncoding("utf-8");
       PrintWriter out =  response.getWriter();
       out.println("<h2>GET</h2>");
       
  -> JSP와 다르게 GET방식과 POST방식이 차이가 명확
  
 -> 단점 : Servlet으로 태그와 함수를 적용해 출력을 위해서
   out.println("<DIV style='font-size: 26px; color: #FF0000; text-decoration: bold;'>");
   등의 out.println 불필요한 틀이 필요
   
 */
package dev.form;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form/study2")     // annotation
public class Study2 extends HttpServlet {
	private static final long serialVersionUID = 1L; // Source Version
       
    public Study2() {    // Default Constructor
      System.out.println("객체 생성");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out =  response.getWriter();
    out.println("<h2>GET</h2>");
    out.println("<DIV style='font-size: 26px; color: #FF0000; text-decoration: bold;'>");
    out.println("  step: " + request.getParameter("step") + "<br>");
    out.println("  next: " + request.getParameter("next") + "<br>");
    out.println("</DIV>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out =  response.getWriter();
    out.println("<h2>POST</h2>");
    out.println("<DIV style='font-size: 26px; color: #FF0000; text-decoration: bold;'>");
    out.println("  step: " + request.getParameter("step") + "<br>");
    out.println("  next: " + request.getParameter("next") + "<br>");
    out.println("</DIV>");
	}
}
