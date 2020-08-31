<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.activity.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.activity.form.label.title" path="title"/>
	
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="authenticated.activity.form.label.startDate" path="startDate"/>
	</jstl:if>	
	<acme:form-moment code="authenticated.activity.form.label.endDate" path="endDate"/>
	<acme:form-money code="authenticated.activity.form.label.budget" path="budget"/>
	
	<acme:form-return code="authenticated.activity.form.button.return"/>	
</acme:form>


