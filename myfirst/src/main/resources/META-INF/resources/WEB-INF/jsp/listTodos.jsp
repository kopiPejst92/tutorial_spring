<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Welcome, ${name}. Here are your ToDos:
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Target date</th>
				<th>Progress</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>

					<td>${todo.description}</td>
					<td>${todo.deadline}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-primary"><i class="fa fa-edit"></i></a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger"><i
							class="fa fa-trash"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">New Todo</a>
</div>
<%@ include file="common/footer.jspf"%>