<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="investor.activity.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="investor.activity.form.label.title" path="title"/>
	
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="investor.activity.form.label.startDate" path="startDate"/>
	</jstl:if>	
	<acme:form-moment code="investor.activity.form.label.endDate" path="endDate"/>
	<acme:form-money code="investor.activity.form.label.budget" path="budget"/>
	
	<acme:form-return code="investor.activity.form.button.return"/>	
</acme:form>


