<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: black;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: black;
}

.tg .tg-k3li {
	font-size: medium;
	text-align: left
}

.tg .tg-s268 {
	text-align: left
}
</style>
<body>
	<table class="tg" width="100%">
		<tr>
			<td width="50%">
				<div align="left">
					<h5>Enter new employee</h5>
					<form method="post" action="addEmployee">
						<table class="tg">
							<tr>
								<th class="tg-s268" colspan="2">Enter new employee details</th>
							</tr>
							<tr>
								<td class="tg-s268"><span style="font-weight: bold">Employee name</span></td>
								<td class="tg-k3li"><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td class="tg-s268"><span style="font-weight: bold">Employee account</span></td>
								<td class="tg-k3li"><input type="text" name="account" /></td>
							</tr>
							<tr>
								<td class="tg-s268"><span style="font-weight: bold">Employee salary</span></td>
								<td class="tg-s268"><input type="text" name="salary" /></td>
							</tr>
							<tr>
								<td class="tg-s268"><span style="font-weight: bold">Employee age</span></td>
								<td class="tg-s268"><input type="text" name="age" /></td>
							</tr>
							<tr>
								<td class="tg-s268" colspan="2"><input type="submit"
									value="Add Employee" /></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
			<td class="tg-s268" >
				<jsp:include page="_getEmployee.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>

