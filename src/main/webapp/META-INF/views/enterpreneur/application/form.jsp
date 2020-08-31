<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="enterpreneur.application.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="enterpreneur.application.form.label.ticker" path="ticker"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="enterpreneur.application.form.label.creationDate" path="creationDate"/>	
	</jstl:if>	
	<acme:form-moment code="enterpreneur.application.form.label.statement" path="statement"/>
	<acme:form-money code="enterpreneur.application.form.label.invOffer" path="invOffer"/>
	
	<jstl:if test="${status == 'PENDING' || (command == 'update' && status == 'REJECTED')}">
	<acme:form-select code="enterpreneur.application.form.label.status" path="status">
		<acme:form-option code="enterpreneur.application.form.label.accepted" value="ACCEPTED"/>
		<acme:form-option code="enterpreneur.application.form.label.rejected" value="REJECTED"/>
	</acme:form-select>
	</jstl:if>
	<acme:form-textarea code="enterpreneur.application.form.label.justification" path="justification"/>
	
	
	<acme:form-submit test="${command == 'show' && status == 'PENDING'}"
	code="enterpreneur.application.form.button.update"
	action="/enterpreneur/application/update"/>
	<acme:form-submit test="${command == 'update'}"
	code="enterpreneur.application.form.button.update"
	action="/enterpreneur/application/update"/>
	
	<acme:form-return code="enterpreneur.application.form.button.return"/>	
</acme:form>


