<%@ page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="patron.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="patron.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="patron.banner.form.label.targetUrl" path="targetUrl"/>
	
	<acme:check-access test="${command == 'create'}">
		<acme:message code="patron.banner.form.credit-card" />
		<acme:form-textbox code="patron.banner.form.label.holderName" path="holderName"/>
		<acme:form-textbox code="patron.banner.form.label.number" path="number"/>
		<acme:form-textbox code="patron.banner.form.label.expirationDate" path="expirationDate"/>
		<acme:form-textbox code="patron.banner.form.label.cvv" path="cvv"/>
	</acme:check-access>
	
	<acme:form-submit test="${command != 'create' && cardId != null}"
	method="get"
	code="patron.banner.form.button.card"
	action="/patron/credit-card/show?id=${cardId}" />
	
	<acme:form-submit test="${command == 'show'}"
	code="patron.banner.form.button.update"
	action="/patron/banner/update"/>
	<acme:form-submit test="${command == 'show'}"
	code="patron.banner.form.button.delete"
	action="/patron/banner/delete"/>
	<acme:form-submit test="${command == 'create'}"
	code="patron.banner.form.button.create"
	action="/patron/banner/create"/>
	<acme:form-submit test="${command == 'update'}"
	code="patron.banner.form.button.update"
	action="/patron/banner/update"/>
	<acme:form-submit test="${command == 'delete'}"
	code="patron.banner.form.button.delete"
	action="/patron/banner/delete"/>
	
	<acme:form-return 
	code="patron.banner.form.button.return"/>
</acme:form>