<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
<script type="text/javascript"
     src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular.min.js">
   </script>
   <script>
   function bookController($scope) {
       $scope.optionsGroup = <% String json = 
                    (String) request.getAttribute("jsonbooks");
       out.println(json);%>;
   }
   </script>
</head>
<body>
	<br>
	
	
	<br>
	<br>
	<form method="post" action="addEmployee">
		Employee name 	 : <input type="text" name="name"/> <br/>
		Employee account : <input type="text" name="account"/> <br/>
		Employee salary  : <input type="text" name="salary"/> <br/>
		Employee age     : <input type="text" name="age"/> <br/>
		<input type="submit" value="Add Employee"/>
	</form>
	<br>
	<br>
	Retrive Employee Details
	<br>
	<form method="post" action="getEmployee">
		Enter Employee ID
		<input type="text" name="employeeId" size="10" id="id"/> <br/> <br/>
		<input type="submit" value="get Employee"/>
	</form>
	
</body>
</html>

