<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="administrator.overture.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="administrator.overture.list.label.title" path="title" width="15"/>
	<acme:list-column code="administrator.overture.list.label.creationdate" path="creationDate" width="15"/>
	<acme:list-column code="administrator.overture.list.label.deadline" path="deadline" width="15"/>
	<acme:list-column code="administrator.overture.list.label.description" path="description" width="15"/>
	<acme:list-column code="administrator.overture.list.label.mmin" path="mmin" width="15"/>
	<acme:list-column code="administrator.overture.list.label.mmax" path="mmax" width="15"/>
	<acme:list-column code="administrator.overture.list.label.email" path="email" width="10"/>
</acme:list>

<acme:form-submit method="get" code="administrator.overture.button.create" action="/administrator/overture/create"/>