<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="administrator.technologyRecord.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="administrator.technologyRecord.list.label.title" path="title" width="25%"/>
	<acme:list-column code="administrator.technologyRecord.list.label.sector" path="activitySector" width="25%"/>
	<acme:list-column code="administrator.technologyRecord.list.label.investorName" path="investorName" width="25%"/>
	<acme:list-column code="administrator.technologyRecord.list.label.description" path="description" width="25%"/>
</acme:list>

<acme:form-submit method="get" code="administrator.technologyRecord.button.create" action="/administrator/technology-record/create"/>