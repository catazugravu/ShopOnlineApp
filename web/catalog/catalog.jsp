<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="./styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Welcome to page</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>ProductCode</th>
                    <th>ProductDescription</th>
                    <th>ProductPrice</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="products" items="${catalog}">
                <tbody>
                    <tr>
                        <td>${products.productID}</td>
                        <td>${products.productCode}</td>
                        <td>${products.productDescription}</td>
                        <td>${products.productPrice}</td>
                        <td>
                            <form method="POST">
                                <input type="hidden" value="${products.productID}" name="productID"/>
                                <input type="submit" value="Add to cart" name="action"/>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>   
                
                
                <form method="Post">
                    <input type="hidden" value="Check out" name="action" >
                    <input type="submit" value="Check out" >
                </form>
                
</table>
</body>
</html>