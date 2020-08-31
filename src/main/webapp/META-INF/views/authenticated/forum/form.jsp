<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.forum.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.forum.form.label.title" path="title"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="authenticated.forum.form.label.creationDate" path="creationDate"/>
	</jstl:if>	
	
	<acme:form-submit test="${command == 'show'}" method="get" code="authenticated.forum.form.button.messages.list" 
	action="/authenticated/message/list?id=${id}"/>
	
	<acme:form-return code="authenticated.forum.form.button.return"/>	
</acme:form>


