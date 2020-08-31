<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="enterpreneur.activity.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="enterpreneur.activity.form.label.title" path="title"/>
	
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="enterpreneur.activity.form.label.startDate" path="startDate"/>
	</jstl:if>	
	<acme:form-moment code="enterpreneur.activity.form.label.endDate" path="endDate"/>
	<acme:form-money code="enterpreneur.activity.form.label.budget" path="budget"/>
	
	<acme:form-submit test="${command == 'create'}" code="enterpreneur.activity.form.button.create"
	action="/enterpreneur/activity/create?idW=${workProgId}" />
	
	
	<acme:form-return code="enterpreneur.activity.form.button.return"/>	
</acme:form>


