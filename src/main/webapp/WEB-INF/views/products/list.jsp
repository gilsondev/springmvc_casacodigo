<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h2>Lista de Produtos</h2>
    <table>
        <tr>
            <td>Titulo</td>
            <td>Valores</td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.title}</td>
                <td>
                    <c:forEach	items="${product.prices}" var="price">
                        [${price.value}	- ${price.bookType}]
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        <a href="/casadocodigo/produtos/form">Novo Produto</a>
    </table>
</body>
</html>
