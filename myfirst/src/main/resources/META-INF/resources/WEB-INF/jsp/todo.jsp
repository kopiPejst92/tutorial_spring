<%@ include file="common/header.jspf"%>
<style>
input[type=text] {
	width: 100%;
}
</style>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h4>Enter Todo details</h4>
		<div style="width: 350px;">
			<form:form method="post" modelAttribute="todo">
				<fieldset class="mb-2">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"
						placeholder="Add description.." />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>
				<fieldset class="mb-2">
					<form:label path="deadline">Deadline</form:label>
					<form:input type="text" path="deadline" required="required"
						placeholder="Add date.." />
					<form:errors path="deadline" cssClass="text-warning" />
				</fieldset>
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
				<input type="submit" class="btn btn-success" value="Finish" />
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer.jspf"%>

	<script type="text/javascript">
		$('#deadline').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>