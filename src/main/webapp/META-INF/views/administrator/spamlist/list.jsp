
<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.spamlist.list.label.spamwordslist" path="spamwordslist" width="20%"/>
	<acme:list-column code="administrator.spamlist.label.threshold" path="threshold" width="40%"/>	
</acme:list>

<acme:menu-separator />

<acme:message code="administrator.sector.h2" />

<acme:list readonly="true">
	<acme:list-column code="administrator.sector.technology" path="as1" width="20%"/>
	<acme:list-column code="administrator.sector.science" path="as2" width="20%"/>
	<acme:list-column code="administrator.sector.arts" path="as3" width="20%"/>
	<acme:list-column code="administrator.sector.business" path="as4" width="20%"/>
	<acme:list-column code="administrator.sector.health" path="as5" width="20%"/>
</acme:list>



