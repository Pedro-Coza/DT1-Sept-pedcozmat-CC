<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="investor.forum.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="investor.forum.form.label.title" path="title"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="investor.forum.form.label.creationDate" path="creationDate"/>
	</jstl:if>	
	
	<acme:form-submit test="${command == 'show'}" method="get" code="investor.forum.form.button.messages.list" 
	action="/investor/message/list?id=${id}"/>
	
	<acme:form-return code="investor.forum.form.button.return"/>	
</acme:form>


