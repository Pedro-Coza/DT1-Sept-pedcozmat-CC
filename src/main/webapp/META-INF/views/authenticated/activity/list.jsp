<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.activity.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.activity.form.label.title" path="title"/>
	<acme:list-column code="authenticated.activity.form.label.startDate" path="startDate"/>
	<acme:list-column code="authenticated.activity.form.label.endDate" path="endDate"/>
	<acme:list-column code="authenticated.activity.form.label.budget" path="budget"/>
</acme:list>
<acme:form-return code="authenticated.activity.form.button.return"/>	