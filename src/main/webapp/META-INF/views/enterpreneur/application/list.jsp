<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<jstl:if test="${command == 'list'}">
	<acme:message code="enterpreneur.application.list.h2" />
</jstl:if>

<jstl:if test="${command == 'list_ticker'}">
	<acme:message code="enterpreneur.application.listTicker.h2" />
</jstl:if>
	
<jstl:if test="${command == 'list_date'}">
	<acme:message code="enterpreneur.application.listDate.h2" />
</jstl:if>

<acme:menu-separator />

<acme:list>
	<acme:list-column code="enterpreneur.application.form.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="enterpreneur.application.form.label.creationDate" path="creationDate" width="20%"/>
	<acme:list-column code="enterpreneur.application.form.label.statement" path="statement" width="20%"/>
	<acme:list-column code="enterpreneur.application.form.label.status" path="status" width="20%"/>
	<acme:list-column code="enterpreneur.application.form.label.invOffer" path="invOffer" width="20%"/>
</acme:list>

<acme:form-return code="enterpreneur.application.form.button.return"/>	