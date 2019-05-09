<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<title>${title}</title>
<script defer src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script defer src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet">

<%--TODO customize this--%>
<jsp:include page="menu.jsp"/>
<jsp:include page="${page}.jsp"/>