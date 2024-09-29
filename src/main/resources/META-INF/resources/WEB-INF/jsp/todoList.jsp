<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="common/header.jspf"  %>
 <%@ include file="common/navigation.jspf" %>
 
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
	
	 <%@ include file="common/footer.jspf"  %>