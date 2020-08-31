<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="investor.investmentRound.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="investor.investmentRound.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="investor.investmentRound.form.label.creationdate" path="creationDate"/>
	</jstl:if>	
	<acme:form-textbox code="investor.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-textbox code="investor.investmentRound.form.label.title" path="title"/>
	<acme:form-money code="investor.investmentRound.form.label.money" path="money"/>
	<acme:form-url code="investor.investmentRound.form.label.info" path="info"/>
	
	<acme:form-submit test="${command == 'show'}" method="get" code="investor.investmentRound.form.button.workingProg"
	action="/investor/activity/list?id=${workProgId}" />
	
	<acme:form-submit test="${appsCount !=0 && command == 'show'}" method="get" code="investor.investmentRound.form.button.application"
	action="/investor/application/list?id=${invRoundId}" />

	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.investmentRound.form.button.forum"
	action="/investor/forum/show?id=${forumId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="investor.investmentRound.form.button.acRecord"
	action="/investor/accounting-record/list?id=${invRoundId}" />
	
	<acme:form-submit test="${command == 'show' && !involved}" method="get" code="investor.investmentRound.form.button.apply"
	action="/investor/application/create?id=${invRoundId}" />	
	
	<acme:form-return code="investor.investmentRound.form.button.return"/>	
</acme:form>


