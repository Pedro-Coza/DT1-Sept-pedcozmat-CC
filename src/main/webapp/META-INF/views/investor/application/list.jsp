<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="investor.application.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="investor.application.form.label.ticker" path="ticker" width="25%"/>
	<acme:list-column code="investor.application.form.label.creationDate" path="creationDate" width="25%"/>
	<acme:list-column code="investor.application.form.label.status" path="status" width="25%"/>
	<acme:list-column code="investor.application.form.label.statement" path="statement" width="25%"/>
	<acme:list-column code="investor.application.form.label.invOffer" path="invOffer" width="25%"/>
</acme:list>

<acme:form-return code="investor.application.form.button.return"/>	