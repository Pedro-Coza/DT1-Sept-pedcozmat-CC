<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="administrator.inquiry.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="administrator.inquiry.list.label.title" path="title" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.creationdate" path="creationDate" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.deadline" path="deadline" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.description" path="description" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.mmin" path="mmin" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.mmax" path="mmax" width="15"/>
	<acme:list-column code="administrator.inquiry.list.label.email" path="email" width="10"/>
</acme:list>

<acme:form-submit method="get" code="administrator.inquiry.button.create" action="/administrator/inquiry/create"/>