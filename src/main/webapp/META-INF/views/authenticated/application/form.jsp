<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.application.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.application.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="authenticated.application.form.label.creationDate" path="creationDate"/>	
	</jstl:if>	
	<acme:form-moment code="authenticated.application.form.label.statement" path="statement"/>
	<acme:form-money code="authenticated.application.form.label.invOffer" path="invOffer"/>
	
	<acme:form-return code="authenticated.application.form.button.return"/>	
</acme:form>


