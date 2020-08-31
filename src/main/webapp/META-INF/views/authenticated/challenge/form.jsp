<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.challenge.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.challenge.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.challenge.form.label.expert" path="expert"/>
	<acme:form-textbox code="authenticated.challenge.form.label.average" path="average"/>
	<acme:form-textbox code="authenticated.challenge.form.label.rookie" path="rookie"/>
	<acme:form-money code="authenticated.challenge.form.label.expertReward" path="expertReward"/>
	<acme:form-money code="authenticated.challenge.form.label.averageReward" path="averageReward"/>
	<acme:form-money code="authenticated.challenge.form.label.rookieReward" path="rookieReward"/>
	
	<acme:form-return code="authenticated.challenge.form.button.return"/>	
</acme:form>


