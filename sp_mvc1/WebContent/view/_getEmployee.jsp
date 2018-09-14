<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<style>
</style>
<body>
	<table style="border: none;">
		<tr>
			<td>
				<div align="left">
					<h5>Retrive Employee Details</h5>
				</div>
			</td>
			<td>
				<div>
					<form method="post" action="getEmployee">
						<span style="font-weight: bold">Enter Employee ID</span> <input
							type="text" name="employeeId" size="10" id="id" /> <br /> <input
							type="submit" value="get Employee" />
					</form>
				</div>
			</td>
		<tr>
			<td>
				<div align="left">
					<h5>Retrive All Employee Details</h5>
				</div>
			</td>
			<td>
				<div>
					<form method="post" action="getAllEmployees">
						<input type="submit" value="get All Employees" />
					</form>
				</div>
			</td>
	</table>
</body>
</html>