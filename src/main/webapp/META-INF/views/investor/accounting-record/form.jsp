<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="investor.accountingRecord.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="investor.accountingRecord.form.label.title" path="title"/>
	<acme:form-textbox code="investor.accountingRecord.form.label.status" path="status"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="investor.accountingRecord.form.label.creationMoment" path="creationMoment"/>
	</jstl:if>	
	<acme:form-textarea code="investor.accountingRecord.form.label.body" path="body"/>

	<acme:form-return code="investor.accountingRecord.form.button.return"/>	
</acme:form>


