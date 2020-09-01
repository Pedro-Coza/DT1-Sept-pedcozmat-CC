<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="enterpreneur.investmentRound.h2" />

<acme:menu-separator />

<acme:form readonly="false">
	<acme:form-textbox code="enterpreneur.investmentRound.form.label.ticker" placeholder="SEC-YY-XXXXXX" path="ticker"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="enterpreneur.investmentRound.form.label.creationdate" path="creationDate"/>
	</jstl:if>	
	<acme:form-textbox code="enterpreneur.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-textbox code="enterpreneur.investmentRound.form.label.title" path="title"/>
	<acme:form-money code="enterpreneur.investmentRound.form.label.money" path="money"/>
	<acme:form-url code="enterpreneur.investmentRound.form.label.info" path="info"/>
	
	<acme:check-access test="${command != 'create' && active == 'INACTIVE'}">
			<acme:form-select code="enterpreneur.invRound.form.label.active" path="active">
				<acme:form-option code="enterpreneur.invRound.form.label.false" value="INACTIVE"/>
				<acme:form-option code="enterpreneur.invRound.form.label.true" value="ACTIVE"/>
			</acme:form-select>
	</acme:check-access>

	<acme:form-textarea code="enterpreneur.investmentRound.form.label.XXXX" path="XXXX"/>

	<acme:form-submit test="${command == 'show' && active == 'INACTIVE'}" code="enterpreneur.investmentRound.form.button.update" action="/enterpreneur/investment-round/update?idW=${workProgId}" />
	<acme:form-submit test="${command == 'update' && active == 'INACTIVE'}" code="enterpreneur.investmentRound.form.button.update" action="/enterpreneur/investment-round/update?idW=${workProgId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="enterpreneur.investmentRound.form.button.workingProg"
	action="/enterpreneur/activity/list?idW=${workProgId}" />
	
	<acme:form-submit test="${command == 'update'}" method="get" code="enterpreneur.investmentRound.form.button.workingProg"
	action="/enterpreneur/activity/list?idW=${idW}" />
	
	<acme:form-submit test="${command == 'show' && active == 'INACTIVE'}" method="get" code="enterpreneur.investmentRound.form.button.addActivity"
	action="/enterpreneur/activity/create?idW=${workProgId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.investmentRound.form.button.forum"
	action="/enterpreneur/forum/show?id=${forumId}" />
	
	<acme:form-submit test="${command == 'show'}" method="get" code="investor.investmentRound.form.button.acRecord"
	action="/enterpreneur/accounting-record/list?id=${invRoundId}" />
	
	<acme:form-submit test="${command == 'update' && active == 'INACTIVE'}" method="get" code="enterpreneur.investmentRound.form.button.addActivity"
	action="/enterpreneur/activity/create?idW=${idW}" />
	
	<acme:form-submit test="${appsCount > 0 && command == 'show'}" method="get" code="enterpreneur.investmentRound.form.button.application"
	action="/enterpreneur/application/list?id=${invRoundId}" />

	<acme:form-submit test="${command == 'create'}" code="enterpreneur.investmentRound.form.button.create"
	action="/enterpreneur/investment-round/create" />
	
	<acme:form-submit test="${command == 'show' && appsCount == 0}" code="enterpreneur.investmentRound.form.button.delete"
	action="/enterpreneur/investment-round/delete" />
	
	<acme:form-return code="enterpreneur.investmentRound.form.button.return"/>	
</acme:form>


