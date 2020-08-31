<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.inquiry.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.inquiry.list.label.title" path="title" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.creationdate" path="creationDate" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.deadline" path="deadline" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.description" path="description" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.mmin" path="mmin" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.mmax" path="mmax" width="15%"/>
	<acme:list-column code="authenticated.inquiry.list.label.email" path="email" width="10%"/>
</acme:list>