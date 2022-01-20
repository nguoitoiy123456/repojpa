<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP +
				MySQL Example - Province Management</h3>
			<hr />

			<input type="button" value="Add province"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Province List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
						
							<th>Name</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our provinces -->
						<c:forEach var="tempProvince" items="${provinces.content}">

							<!-- construct an "update" link with province id -->
							<c:url var="updateLink" value="/province/updateForm">
								<c:param name="provinceId" value="${tempProvince.id}" />
							</c:url>

							<!-- construct an "delete" link with province id -->
							<c:url var="deleteLink" value="/province/delete">
								<c:param name="provinceId" value="${tempProvince.id}" />
							</c:url>

							<tr>
								<td>${tempProvince.name}</td>
							
							
								
								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this province?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
				<div>
				<div class="d-flex flex-row align-items-center">
				      <c:if test="${provinces.hasPrevious()}">
				           <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?'">&laquo; first</button>
				           <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                    onclick="location.href = 'page?page=${provinces.number - 1}'">previous</button>
				      </c:if>
				
				      <c:if test="${provinces.totalPages != 1}">
				            <label style="margin: 2px 8px 2px 8px">
				                 Page ${provinces.number +1 } of     ${provinces.totalPages}
				            </label>
				      </c:if>
				
				      <c:if test="${provinces.hasNext()}">
				            <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?page=${provinces.number + 1}'">next</button>
				            <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?page=${provinces.totalPages -1}'">last &raquo;</button>                                    
				      </c:if>
				    </div>
				</div>
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>









