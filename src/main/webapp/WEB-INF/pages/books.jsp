<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="5" style="font-size: 24px">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Author</td>
            <td>Date</td>
            <td>Price</td>
            <td>Delete</td>
            <td>Update</td>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.date}</td>
                <td>${book.price}</td>
                <td>
                    <a href="<c:url value="/delete/${book.id}"/>">Delete</a>
                </td>
                <td>
                    <a href="<c:url value="/update/${book.id}"/>">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:url var="addAction" value="/books/add"/>

    <form:form action="${addAction}" commandName="book">
        <table>
            <c:if test="${!empty book.name}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <%--<form:hidden path="id"/>--%>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="author">
                        <spring:message text="Author"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="author"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="date">
                        <spring:message text="Date"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="date"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty book.name}">
                        <input type="submit"
                               value="<spring:message text="Edit Book"/>"/>
                    </c:if>
                    <c:if test="${empty book.name}">
                        <input type="submit"
                               value="<spring:message text="Add Book"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>