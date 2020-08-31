<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="anonymous.toolRecord.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.toolRecord.form.label.title" path="title"/>
	<acme:form-textbox code="anonymous.toolRecord.form.label.sector" path="activitySector"/>
	<acme:form-textbox code="anonymous.toolRecord.form.label.investorName" path="investorName"/>
	<acme:form-textarea code="anonymous.toolRecord.form.label.description" path="description"/>
	<acme:form-url code="anonymous.toolRecord.form.label.website" path="website"/>
	<acme:form-textbox code="anonymous.toolRecord.form.label.email" path="email"/>
	<acme:form-textbox code="anonymous.toolRecord.form.label.source" path="source"/>
	<acme:form-textbox code="anonymous.toolRecord.form.label.rating" path="rating"/>
	
	<acme:form-return code="anonymous.toolRecord.form.button.return"/>	
</acme:form>


