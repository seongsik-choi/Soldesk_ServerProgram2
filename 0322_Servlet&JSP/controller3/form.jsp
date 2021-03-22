<%-- 
0322
3. View: JSP 
1) Form
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title><%=request.getAttribute("title") %></title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
</head> 
 
<body>
<DIV style='text-align: center;'>
<H1>Controller 3</H1>
<H2><%=request.getAttribute("title") %></H2>
  <form name='frm' method='post' action='/mvc/controller3/img.do3'>
    <label>
      <input type='radio' name='code' value='img1' checked="checked"> 봄 
    </label>
    <label>
      <input type='radio' name='code' value='img2'> 여름
    </label>
    <label>
      <input type='radio' name='code' value='img3'> 가을
    </label>
    <label>
      <input type='radio' name='code' value='img4'> 겨울
    </label><br><br>
    <button type='submit'>실행</button>
  </form>
</DIV>
 
</body>
 
</html> 
 
 