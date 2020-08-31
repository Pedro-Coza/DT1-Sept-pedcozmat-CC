<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.technologyRecord.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.technologyRecord.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.technologyRecord.form.label.sector" path="activitySector"/>
	<acme:form-textbox code="authenticated.technologyRecord.form.label.investorName" path="investorName"/>
	<acme:form-textarea code="authenticated.technologyRecord.form.label.description" path="description"/>
	<acme:form-url code="authenticated.technologyRecord.form.label.website" path="website"/>
	<acme:form-textbox code="authenticated.technologyRecord.form.label.email" path="email"/>
	<acme:form-textbox code="authenticated.technologyRecord.form.label.source" path="source"/>
	<acme:form-textbox code="authenticated.technologyRecord.form.label.rating" path="rating"/>
	
	<acme:form-return code="authenticated.technologyRecord.form.button.return"/>	
</acme:form>


