<%-- 
0323
 CalcCont.java의 View 부분(jsp)
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>calc1.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head>
<body>
<DIV class='container'>
<DIV class='content'>
 <H1>계산기(Scriptlet calc1.jsp)</H1>
 <%= request.getAttribute("msg")%> 계산기<br> <!-- setAttritube(addObject) -->
  수1: <%=request.getParameter("no1") %><br> <!--  getParameter : url로 입력 ?no1=100&no2=50-->
  수2: <%=request.getParameter("no2") %><br>
  결과: <%= request.getAttribute("result")%> <br><br> <!-- setAttritube(addObject) -->
  
 <H1>계산기(EL calc1.jsp)</H1>
  ${msg } 계산기 <br>        <!-- setAttritube(addObject) -->
  수1: ${param.no1 }<br> <!--  getParameter : url로 입력 ?no1=100&no2=50-->
  수2: ${param.no2 }<br>
  결과: ${requestScope.result }<br><br> <!-- requestScope.result == result  -->
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>