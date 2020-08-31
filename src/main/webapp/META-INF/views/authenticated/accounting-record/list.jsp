<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.accountingRecord.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.accountingRecord.form.label.title" path="title" width="25%"/>
	<jstl:if test="${command == 'show'}">
		<acme:list-column code="authenticated.accountingRecord.form.label.creationMoment" path="creationMoment" width="25%"/>
	</jstl:if>
	<acme:list-column code="authenticated.accountingRecord.form.label.status" path="status" width="25%"/>
	<acme:list-column code="authenticated.accountingRecord.form.label.body" path="body" width="25%"/>
</acme:list>

<acme:form-return code="authenticated.accountingRecord.form.button.return"/>	