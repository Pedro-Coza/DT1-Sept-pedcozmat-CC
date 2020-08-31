<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	<acme:form-textbox code="enterpreneur.message.form.label.title" path="title" />
	<acme:check-access test="${command != 'create'}">
		<acme:form-moment code="enterpreneur.message.form.label.creationMoment" path="creationMoment"/>
	</acme:check-access>
	
	<acme:form-textbox code="enterpreneur.message.form.label.tags" path="tags"/>
	<acme:form-textbox code="enterpreneur.message.form.label.body" path="body"/>
	
	<acme:form-return code="enterpreneur.message.form.button.return" />
</acme:form>
