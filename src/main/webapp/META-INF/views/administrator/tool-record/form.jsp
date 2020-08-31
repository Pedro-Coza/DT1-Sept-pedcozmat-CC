<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="administrator.toolRecord.h2" />

<acme:menu-separator />

<acme:form>
	<acme:form-textbox code="administrator.toolRecord.form.label.title" path="title"/>
	<acme:form-textbox code="administrator.toolRecord.form.label.sector" path="activitySector"/>
	<acme:form-textbox code="administrator.toolRecord.form.label.investorName" path="investorName"/>
	<acme:form-textarea code="administrator.toolRecord.form.label.description" path="description"/>
	<acme:form-url code="administrator.toolRecord.form.label.website" path="website"/>
	<acme:form-textbox code="administrator.toolRecord.form.label.email" path="email"/>
	<acme:form-textbox code="administrator.toolRecord.form.label.source" path="source"/>
	<acme:form-textbox code="administrator.toolRecord.form.label.rating" path="rating"/>
	
	<acme:form-submit test="${command == 'show' }" 
	code="administrator.tool-record.form.button.delete"
	action="/administrator/tool-record/delete" />
	
	<acme:form-submit test="${command == 'show' }" 
	code="administrator.tool-record.form.button.update"
	action="/administrator/tool-record/update" />
	
	<acme:form-submit test = "${command == 'create'}"
	code="administrator.tool-record.form.button.create" 
	action="/administrator/tool-record/create"/>

	<acme:form-submit test="${command == 'delete' }" 
	code="administrator.tool-record.form.button.delete"
	action="/administrator/tool-record/delete" />
	
	<acme:form-submit test="${command == 'update' }" 
	code="administrator.tool-record.form.button.update"
	action="/administrator/tool-record/update" />
	
	<acme:form-return code="administrator.toolRecord.form.button.return"/>	
</acme:form>


