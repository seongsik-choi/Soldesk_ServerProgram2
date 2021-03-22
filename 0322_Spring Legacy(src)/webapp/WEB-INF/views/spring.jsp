<%-- 
0322
2) 추가된 JSP View
  return spring; // <-> String view = "/controller4/form.jsp";를 의미 + dispacther 사용 no
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
*{ 
   font-size: 32px;
 }
</style>
</head>
<body>
<DIV class='container'>
<DIV class='content'>
  URL: <%=request.getRequestURL() %><br>
  URI: <%=request.getRequestURI() %><br>
  현재 시간: <%=new Date().toLocaleString() %>
</DIV> <!-- content END -->
</DIV> <!-- container END -->
 
</body>
</html>