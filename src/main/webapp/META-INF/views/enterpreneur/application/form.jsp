<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="enterpreneur.application.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="enterpreneur.application.form.label.ticker" readonly="true" path="ticker"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="enterpreneur.application.form.label.creationDate" readonly="true" path="creationDate"/>	
	</jstl:if>	
	<acme:form-moment code="enterpreneur.application.form.label.statement" readonly="true" path="statement"/>
	<acme:form-money code="enterpreneur.application.form.label.invOffer" readonly="true" path="invOffer"/>
	
	<jstl:if test="${command == 'show'}">
		<acme:form-select code="enterpreneur.application.form.label.status" path="status">
		<acme:form-option code="enterpreneur.application.form.label.pending" value="PENDING"/>
		<acme:form-option code="enterpreneur.application.form.label.accepted" value="ACCEPTED"/>
		<acme:form-option code="enterpreneur.application.form.label.rejected" value="REJECTED"/>
	</acme:form-select>
	</jstl:if>
	
	<jstl:if test="${(command == 'update' && status == 'PENDING') || (command == 'update' && status == 'REJECTED')}">
	<acme:form-select code="enterpreneur.application.form.label.status" path="status">
		 <acme:form-option code="enterpreneur.application.form.label.pending" value="PENDING"/>
		<acme:form-option code="enterpreneur.application.form.label.accepted" value="ACCEPTED"/>
		<acme:form-option code="enterpreneur.application.form.label.rejected" value="REJECTED"/>
	</acme:form-select>
	</jstl:if>
	<acme:form-textarea code="enterpreneur.application.form.label.justification" path="justification"/>

	<acme:menu-separator />
	
	<acme:message code="investor.application.xxxxOffer.h3" />
	
	<acme:form-textbox code="enterpreneur.application.form.label.xxxxOffer" readonly="true" path="xxxxOffer"/>
		
	<jstl:if test="${command == 'show' && !pwdProtected}">
		<acme:form-textbox code="enterpreneur.application.form.label.moreInfo"  readonly="true" path="link"/>
	</jstl:if>
	
	<jstl:if test="${command != 'create' && pwdProtected && !pwdOk}">
		<acme:form-password code="enterpreneur.application.form.label.moreInfo"  readonly="true" path="link"/>
		<acme:form-textbox code="enterpreneur.application.form.label.password" path="password"/>
		<acme:form-submit code="enterpreneur.application.form.button.revealLink" action="/enterpreneur/application/update?pwdProtected=true"/>
	</jstl:if>
	
	<jstl:if test="${command == 'update' && pwdProtected && pwdOk}">
		<acme:form-textbox code="enterpreneur.application.form.label.moreInfo"  readonly="true" path="link"/>
		<acme:form-textbox code="enterpreneur.application.form.label.password"  path="password"/>
	</jstl:if>
	
	<acme:menu-separator />
	
	<acme:form-submit test="${command == 'show' && status == 'PENDING'}"
	code="enterpreneur.application.form.button.update"
	action="/enterpreneur/application/update"/>
	<acme:form-submit test="${command == 'update'}"
	code="enterpreneur.application.form.button.update"
	action="/enterpreneur/application/update"/>
	
	<acme:form-return code="enterpreneur.application.form.button.return"/>	
</acme:form>


