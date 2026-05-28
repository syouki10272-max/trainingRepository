<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    String errorMsg = (String) request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<% if(errorMsg != null){ %>
<p style=color:red><%=errorMsg %></p>
<%} %>
<form action="Login" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="text" name="passward"><br>
<input type="submit" value="ログイン"><br>
</form>
<a href="main.jsp">トップへ</a>
</body>
</html>