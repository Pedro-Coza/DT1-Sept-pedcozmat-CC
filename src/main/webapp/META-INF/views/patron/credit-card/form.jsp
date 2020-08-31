<%@ page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="patron.credit-card.form.label.holderName" path="holderName"/>
	<acme:form-textbox code="patron.credit-card.form.label.number" path="number"/>
	<acme:form-textbox code="patron.credit-card.form.label.expirationDate" path="expirationDate"/>
	<acme:form-textbox code="patron.credit-card.form.label.cvv" path="cvv"/>
	
	<acme:form-return 
	code="patron.credit-card.form.button.return"/>
	
</acme:form>