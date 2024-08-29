<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

 <head>
 <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
   <title> Login Page </title>
 </head>
 <body>

  <h1>Welcome  ${name}  </h1>
  <h3>Your To Do List's </h3>
  <hr></hr>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done ? </th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoList}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning"> DELETE </a></td>
						<td><a href="update-todo?id=${todo.id}"  class="btn btn-success"> UPDATE </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success"> Add To Do </a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  
 </body>
</html>