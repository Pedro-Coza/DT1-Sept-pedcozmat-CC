<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.toolRecord.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.toolRecord.list.label.title" path="title" width="25%"/>
	<acme:list-column code="authenticated.toolRecord.list.label.sector" path="activitySector" width="25%"/>
	<acme:list-column code="authenticated.toolRecord.list.label.investorName" path="investorName" width="25%"/>
	<acme:list-column code="authenticated.toolRecord.list.label.description" path="description" width="25%"/>
</acme:list>