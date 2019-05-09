<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script defer src="/js/book.js"></script>

<div class="container">
    <button type="button" class="btn btn-primary" onclick="showModal();">
        <spring:message code="book.newBook"/>
    </button>
    <br/>

    <c:forEach var="book" items="${books}">
        <p>
            <b>${book.name} </b>
            <a href="#">
                <i class="ui-icon-pencil" id="editBook" onclick="showEdit(${book.id});">*</i>
            </a>
            <br/>
                ${book.longDescription}
        </p>
    </c:forEach>
</div>

<div class="modal" id="newBook" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"><spring:message code="book.newBook"/></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="/admin/book/create" method="post" id="newBookForm" modelAttribute="newBook">
                    <form:hidden path="id" id="id"/>

                    <label for="name"><spring:message code="book.name"/></label>
                    <form:input path="name" class="form-control" id="name"/>

                    <label for="shortDescription"><spring:message code="book.shortDescription"/></label>
                    <form:input path="description" class="form-control" id="shortDescription"/>

                    <label for="longDescription"><spring:message code="book.longDescription"/></label>
                    <form:textarea path="longDescription" class="form-control" id="longDescription" rows="10"/>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="$('#newBookForm').submit();"><spring:message code="common.save"/>
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code="common.cancel"/></button>
            </div>
        </div>
    </div>
</div>