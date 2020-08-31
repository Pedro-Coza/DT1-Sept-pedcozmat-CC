<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="authenticated.notice.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.notice.list.label.header" path="header"/>
	<acme:form-textbox code="authenticated.notice.list.label.title" path="title"/>
	<acme:form-moment code="authenticated.notice.list.label.creationdate" path="creationDate"/>
	<acme:form-moment code="authenticated.notice.list.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.notice.list.label.body" path="body"/>
	<acme:form-url code="authenticated.notice.list.label.relatedlinks" path="relatedLinks"/>
	
	<acme:form-return code="authenticated.notice.form.button.return"/>	
</acme:form>


