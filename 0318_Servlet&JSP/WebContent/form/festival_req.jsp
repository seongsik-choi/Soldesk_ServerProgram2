<%-- 
0318
 [02] Setvlet에서 JSP form으로 데이터 보내기       
  [01] Setvlet에서 JSP form으로 데이터 보내기(반대)
  - Forward: request, response 객체를 계속 가지고 이동 가능
              아래의 경우 view 변수의 경로는 'WebContent' 하위 경로를 지정
              
  ▶ 정리) 브라우저 -> Request -> JSP/Servlet -> (Call forwarding) -> JSP/Servlet -> Response -> 브라우저
        Servlet 실행 -> Servlet(setAttritube) 전송 및 호출 -> JSP(getAttritube) 받기 및 호출
        -> 서버 층에서 JSP/Servlet 모두 실행 후 Response  -> JSP 로직 숨김(Servlet으로 실행되는 것 처럼 보임)     
 
  ▶ Servlet annotation과 JSP action을 맞춰주기
  ▶  @WebServlet("/form/festival_req.seoul")     // annotation        
  ▶   <FORM name='frm' method="POST" action='/mvc/form/festival_req.seoul'>     
   
   -> 실행을 Servlet 쪽에서   : http://localhost:9090/mvc/form/festival_req.seoul
   -> url 확인시 어떤 로직(.jsp, php)으로 개발했는지 로직을 숨길수있음   
              
  ▶ 사용예(Servlet 쪽)
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                 throws ServletException, IOException {
    
    request.setAttribute("title", "연꽃축제");  // 키와 값의 구조
    request.setAttribute("where", "충남부여");  // 키와 값의 구조
    request.setAttribute("when", "7월 20일 ~ 7월27일");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/form/festival_req.jsp"); // .jsp 호출
    dispatcher.forward(request, response); // request, response 객체가 jsp 전달.
  }
 
  1. 서블릿 제작 실습
   - jsp 파일을 바로 접근하면 데이터를 볼 수 없음, 비정상적인 접근일 경우.
   - servlet을 이용하여 접근해야 jsp 파일에 데이터가 출력됨.
   - 정상적인 접근: http://localhost:9090/mvc/form/festival_req.do
   - jsp 파일에서 post 전송한 경우
   
 ▶  GET방식 :  처리쪽에서(SetAttirtube)로 데이터 보내기 -> JSP에서(getAttritube)로 받기
  1) Servlet 쪽 doGet : equest.setAttribute("title", "연꽃축제");  // 키와 값의 구조
  2) JSP 내 scriptlet :  <input type='text' value=<%=request.getAttribute("title") %>>
   
  2) 실행
   - JSP 직접 실행하면 null 출력됨: http://localhost:9090/mvc/form/festival_req.jsp
   - Servlet 실행시 폼에 초기값 출력: http://localhost:9090/mvc/form/festival_req.do 
   
--%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html>
<html> 
<head> 
<meta charset="UTF-8"> 
<title>축제 예약</title> 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
 
<DIV class='title_line'><strong>축제 예약</strong></DIV>
 
 <FORM name='frm' method="POST" action='/mvc/form/festival_req.seoul'>
  <TABLE style='margin: 0px auto;'>
    <TR>
      <TH>축제 이름</TH>
      <TD><input type='text' name='title' size='40' value=<%=request.getAttribute("title") %>> </TD>
    </TR>
    <TR>
      <TH>개최 지역</TH>
      <TD><input type='text' name='where' size='40' value=<%=request.getAttribute("where") %>></TD>
    </TR>
    <TR>
      <TH>개최 기간</TH>
      <TD><input type='text' name='when' size='40' value=<%=request.getAttribute("when") %>></TD>
    </TR>
  </TABLE>
 
  <DIV class='bottom_menu'>
    <input type='submit' value='전송'>
  </DIV>
</FORM>
 
 
</body>
</html>