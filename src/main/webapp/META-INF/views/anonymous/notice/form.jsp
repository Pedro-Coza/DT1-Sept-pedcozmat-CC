<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="anonymous.notice.h2" />

<acme:menu-separator />

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.notice.list.label.header" path="header"/>
	<acme:form-textbox code="anonymous.notice.list.label.title" path="title"/>
	<acme:form-moment code="anonymous.notice.list.label.creationdate" path="creationDate"/>
	<acme:form-moment code="anonymous.notice.list.label.deadline" path="deadline"/>
	<acme:form-textarea code="anonymous.notice.list.label.body" path="body"/>
	<acme:form-url code="anonymous.notice.list.label.relatedlinks" path="relatedLinks"/>
	
	<acme:form-return code="anonymous.notice.form.button.return"/>	
</acme:form>


