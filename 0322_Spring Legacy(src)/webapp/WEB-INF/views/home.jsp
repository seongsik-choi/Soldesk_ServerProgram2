<%--
0322
1) 기본적으로 생성된 JSP View
  return home; // <-> String view = "/controller4/form.jsp";를 의미 + dispacther 사용 no
 --%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
</head>
<body>
  <h1>Spring 처음 예제입니다.</h1>
 
  <H2> The time on the server is ${serverTime}. </H2>
</body>
</html>