<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="administrator.notice.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="administrator.notice.form.label.header" path="header"/>
	<acme:form-textbox code="administrator.notice.form.label.title" path="title"/>
	
	<jstl:if test="${command == 'show'}">
		<acme:form-moment code="administrator.notice.form.label.creationdate" path="creationDate" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.notice.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.notice.form.label.body" path="body"/>
	<acme:form-url code="administrator.notice.form.label.relatedlinks" path="relatedLinks"/>
 	<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="administrator.notice.form.checkbox" path="accept"/>		
	</jstl:if>

	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.notice.form.button.create" 
	action="/administrator/notice/create"/>
	
	<acme:form-return code="administrator.notice.form.button.return"/>	
</acme:form>


