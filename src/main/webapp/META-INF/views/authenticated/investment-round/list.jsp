<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="authenticated.investmentRound.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="authenticated.investmentRound.form.label.ticker" path="ticker" width="20%"/>
	<jstl:if test="${command == 'show'}">
		<acme:list-column code="authenticated.investmentRound.form.label.creationdate" path="creationDate" width="20%"/>
	</jstl:if>
	<acme:list-column code="authenticated.investmentRound.form.label.kindRound" path="kindRound" width="20%"/>
	<acme:list-column code="authenticated.investmentRound.form.label.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.investmentRound.form.label.money" path="money" width="20%"/>
</acme:list>