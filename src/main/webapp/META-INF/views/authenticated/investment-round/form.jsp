<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.investmentRound.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investmentRound.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="authenticated.investmentRound.form.label.creationdate" path="creationDate"/>
	</jstl:if>	
	<acme:form-textbox code="authenticated.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-textbox code="authenticated.investmentRound.form.label.title" path="title"/>
	<acme:form-money code="authenticated.investmentRound.form.label.money" path="money"/>
	<acme:form-url code="authenticated.investmentRound.form.label.info" path="info"/>
	
	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.investmentRound.form.button.workingProg"
	action="/authenticated/activity/list?id=${workProgId}" />
	
	<acme:form-submit test="${appsCount !=0 && command == 'show'}" method="get" code="authenticated.investmentRound.form.button.application"
	action="/authenticated/application/list?id=${invRoundId}" />

	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.investmentRound.form.button.forum"
	action="/authenticated/forum/show?id=${forumId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.investmentRound.form.button.acRecord"
	action="/authenticated/accounting-record/list?id=${invRoundId}" />
	
	<acme:form-return code="authenticated.investmentRound.form.button.return"/>	
</acme:form>


