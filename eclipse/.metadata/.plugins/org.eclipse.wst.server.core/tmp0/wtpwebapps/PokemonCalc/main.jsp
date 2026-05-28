<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    <% 
    User loginUser = (User) session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポケモン数値計算</title>
</head>
<body>
<h1>ポケモン数値計算サイト</h1>
<% if(loginUser == null){ %>
<a href="Login">ログインはこちら</a>
<%}else{ %>
<%= loginUser.getUserName() %>さん、こんにちは<br>
<a href="Logout">ログアウト</a>
<%} %>
</body>
</html>