<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="bookkeeper.investmentRound.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="bookkeeper.investmentRound.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="bookkeeper.investmentRound.form.label.creationdate" path="creationDate"/>
	</jstl:if>	
	<acme:form-textbox code="bookkeeper.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-textbox code="bookkeeper.investmentRound.form.label.title" path="title"/>
	<acme:form-money code="bookkeeper.investmentRound.form.label.money" path="money"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.info" path="info"/>
	
	<acme:form-submit test="${command == 'show'}" method="get" code="bookkeeper.investmentRound.form.button.workingProg"
	action="/bookkeeper/activity/list?id=${workProgId}" />
	
	<acme:form-submit test="${appsCount !=0 && command == 'show'}" method="get" code="bookkeeper.investmentRound.form.button.application"
	action="/bookkeeper/application/list?id=${invRoundId}" />

	<acme:form-submit test="${involved == true && command == 'show'}" method="get" code="bookkeeper.investmentRound.form.button.forum"
	action="/bookkeeper/forum/list_mine?id=${invRoundId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="bookkeeper.investmentRound.form.button.acRecord"
	action="/bookkeeper/accounting-record/list?id=${invRoundId}" />
	
	<acme:form-return code="bookkeeper.investmentRound.form.button.return"/>	
</acme:form>


