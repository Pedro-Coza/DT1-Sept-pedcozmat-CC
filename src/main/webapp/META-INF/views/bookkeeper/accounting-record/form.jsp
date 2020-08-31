<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="bookkeeper.accountingRecord.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="bookkeeper.accountingRecord.form.label.title" path="title"/>
	<acme:form-textbox code="bookkeeper.accountingRecord.form.label.status" path="status"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="bookkeeper.accountingRecord.form.label.creationMoment" path="creationMoment"/>
	</jstl:if>	
	<acme:form-textarea code="bookkeeper.accountingRecord.form.label.body" path="body"/>

	<acme:form-return code="bookkeeper.accountingRecord.form.button.return"/>	
</acme:form>


