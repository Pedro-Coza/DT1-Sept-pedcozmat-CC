<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="administrator.challenge.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="administrator.challenge.form.label.title" path="title" width="20%"/>
	<acme:list-column code="administrator.challenge.form.label.deadline" path="deadline" width="20%"/>
	<acme:list-column code="administrator.challenge.form.label.description" path="description" width="20%"/>
	<acme:list-column code="administrator.challenge.form.label.expert" path="expert" width="20%"/>
	<acme:list-column code="administrator.challenge.form.label.expertReward" path="expertReward" width="20%"/>
</acme:list>

<acme:form-submit method="get" code="administrator.challenge.button.create" action="/administrator/challenge/create" />