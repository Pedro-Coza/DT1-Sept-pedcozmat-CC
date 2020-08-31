<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="investor.application.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" placeholder="SEC-YY-XXXXXX"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="investor.application.form.label.creationDate" path="creationDate"/>	
	</jstl:if>	
	<acme:form-textbox code="investor.application.form.label.statement" path="statement"/>
	<acme:form-money code="investor.application.form.label.invOffer" path="invOffer"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-textarea code="enterpreneur.application.form.label.justification" readonly="true" path="justification"/>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.create"
	action="/investor/application/create" />
		
	<acme:form-return code="investor.application.form.button.return"/>	
</acme:form>


