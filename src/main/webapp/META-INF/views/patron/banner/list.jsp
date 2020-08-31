<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="patron.banner.list.label.picture" path="picture" width="20%"/>
    <acme:list-column code="patron.banner.list.label.slogan" path="slogan" width="40%"/>      
    <acme:list-column code="patron.banner.list.label.targetUrl" path="targetUrl" width="40%"/>
</acme:list>

<acme:form-submit method="get" code="patron.banner.button.create" action="/patron/banner/create"/>