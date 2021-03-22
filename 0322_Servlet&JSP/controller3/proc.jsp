<%-- 
0322
 2) 결과
 ▷ /WebContent/controller3/proc.jsp 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
</head> 
 
<body>
<DIV style='text-align: center;'>
  <H1>MVC(JSP Model 2) Controller 3 </H1>
  <H2><A href='./img.do3'>이미지 List</A></H2>
  <br>
  <H2><%=request.getAttribute("title") %></H2>
  <%
  String fname = (String)request.getAttribute("fname");
  %>
  <IMG src="./images/<%=fname %>" style='width: 60%;'>
 
</DIV>
</body>
 
</html> 
 
  
  