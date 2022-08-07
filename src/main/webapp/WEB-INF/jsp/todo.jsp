<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container md-6">
	<form:form method="post" modelAttribute="todo">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control date"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success btn-md-5">Save</button>
	</form:form>
</div>
<%@ include file="common/footer.jsp" %>
<style>
/* fix bootstrap-datepicker positional bug */
.datepicker {
  transform: translate(0, 3.1em);
}
</style>