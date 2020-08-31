<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="enterpreneur.forum.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="enterpreneur.forum.form.label.title" path="title"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="enterpreneur.forum.form.label.creationDate" path="creationDate"/>
	</jstl:if>	
	
	<acme:form-submit test="${command == 'show'}" method="get" code="enterpreneur.forum.form.button.messages.list" 
	action="/enterpreneur/message/list?id=${id}"/>
	
	<acme:form-return code="enterpreneur.forum.form.button.return"/>	
</acme:form>


