<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro	de produtos</title>
</head>
<body>

<spring:hasBindErrors name="product">
    <ul>
        <c:forEach var="error" items="${errors.allErrors}">
            <li><spring:message code="${error.code}" text="${error.defaultMessage}"/></li>
        </c:forEach>
    </ul>
</spring:hasBindErrors>

<form:form method="post" action='${spring:mvcUrl("saveProduct").build()}' commandName="product" enctype="multipart/form-data">
    <div>
        <label for="title">Titulo</label>
        <form:input path="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <label for="description">Descrição</label>
        <form:textarea path="description" rows="10" cols="20" />
        <form:errors path="description"/>
    </div>
    <div>
        <label for="pages">Número de paginas</label>
        <form:input path="pages" />
        <form:errors path="pages"/>
    </div>
    <div>
        <label for="releaseDate">Data de Lançamento</label>
        <form:input path="releaseDate" type="date" />
        <form:errors path="releaseDate"/>
    </div>
    <c:forEach items="${types}" var="bookType" varStatus="status">
        <div>
            <label for="price_${bookType}">${bookType}</label>
            <input type="text" name="prices[${status.index}].value" id="price_${bookType}">
            <input type="hidden" name="prices[${status.index}].bookType" value="${bookType}">
        </div>
    </c:forEach>
    <div>
        <label for="summary">Sumario do Livro</label>
        <input type="file" name="summary" />
        <form:errors path="summaryPath" />
    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>
</form:form>
</body>
</html>