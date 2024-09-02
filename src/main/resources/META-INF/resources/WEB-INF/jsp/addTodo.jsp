<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
  <%@ include file="common/header.jspf"  %>
  <%@ include file="common/navigation.jspf"  %>
  
  <h1>Welcome  ${name}  </h1>
  <h3>Your To Do List's </h3>
  <hr></hr>
	<div class="container">
		<form:form  method="post" modelAttribute="todo">
		
		  <fieldset class="mb-3">
		    <form:label path="description">Description : </form:label>
			<form:input type="text"   path="description" required = "required" />
			<form:errors path="description" cssClass="text-warning" />
		  </fieldset>
		  
		  <fieldset class="mb-3">
		    <form:label path="targetDate">Target Date : </form:label>
		    <form:input type="text"  path="targetDate" required = "required"/>
			<form:errors path="targetDate" cssClass="text-warning" />
		  </fieldset>
		  
			<form:input  type="hidden"   path="id" />
			<form:input  type="hidden"   path="done" />
			<input type="submit" class="btn btn-success" >
			
		</form:form >
	</div>
	
  <%@ include file="common/footer.jspf"  %>
  <script type="text/javascript">
  $('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
  </script>



