<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:message code="enterpreneur.forum.list.h2" />

<acme:menu-separator />

<acme:list>
	<acme:list-column code="enterpreneur.forum.form.label.title" path="title"/>
	<acme:list-column code="enterpreneur.forum.form.label.creationDate" path="creationDate"/>
</acme:list>
<acme:form-return code="enterpreneur.forum.form.button.return"/>	