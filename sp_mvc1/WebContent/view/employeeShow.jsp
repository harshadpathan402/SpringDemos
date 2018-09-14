<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="left">
		<br>
		Employee Id            : ${employee.id}
		<br>
		Employee Name 		   : ${employee.name}
		<br>
		Emloyee account number : ${employee.account}
		<br>
		Employee Salery 	   : ${employee.salary}
	</div>
	<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>
	<br>
	<div align="left">
	<a href="return">BackToHome </a>
	</div>
</body>
</html>
