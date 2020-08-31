<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.notice.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.notice.list.label.title" path="title" width="25%"/>
	<acme:list-column code="authenticated.notice.list.label.creationdate" path="creationDate" width="25%"/>
	<acme:list-column code="authenticated.notice.list.label.deadline" path="deadline" width="25%"/>
	<acme:list-column code="authenticated.notice.list.label.header" path="header" width="25%"/>
</acme:list>