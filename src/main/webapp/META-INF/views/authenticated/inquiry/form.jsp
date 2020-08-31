<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.inquiry.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.inquiry.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.inquiry.form.label.creationdate" path="creationDate"/>
	<acme:form-moment code="authenticated.inquiry.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.inquiry.form.label.description" path="description"/>
	<acme:form-money code="authenticated.inquiry.form.label.mmin" path="mmin"/>
	<acme:form-money code="authenticated.inquiry.form.label.mmax" path="mmax"/>
	<acme:form-textbox code="authenticated.inquiry.form.label.email" path="email"/>
	
	<acme:form-return code="authenticated.inquiry.form.button.return"/>	
</acme:form>


