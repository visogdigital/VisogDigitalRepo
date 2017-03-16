<%@page import="com.visog.util.User"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.logout{
		margin-top: 0px;
		margin-left: 1250px;
				}
.center{
		margin-left: 500px;
		}				
				
</style>
</head>
<body>
<div class = "page-header"> 
<div class="logout">
<%User user = (User) session.getAttribute("User"); %>
<h3>Hi <%=user.getName() %></h3>
  <form action="Logout" method="post">
<input type="submit" class="btn btn-danger" value="Logout" >
</form>
  </div> 
</div>
<div class="center">

<strong>Your Email</strong>: <%=user.getEmail() %><br>
<strong>Your Country</strong>: <%=user.getCountry() %><br>
<br>
</div>
</body>
</html>