<%-- 
    Document   : checkout
    Created on : Dec 12, 2018, 4:17:38 PM
    Author     : TRINH_PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>quantity</th>
                    <th>productCode</th>
                    <th>ProductDescription</th>
                    <th>ProductPrice</th>  
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="cart" items="${sessionScope.cart.items}">
                <tbody>
                    <tr>
                        <td>
                            <form method="POST">
                                <input style="width: 30px "type="text" value="${cart.quantity}">
                                <input type="hidden" value="Check out" name="action">
                                <input type="submit" value="Update"> 
                            </form>
                        </td>
                        <td>${cart.product.productCode}</td>
                        <td>${cart.product.productDescription}</td>
                        <td>${cart.product.productPrice}</td>
                        <td> </td>
                        <td>               
                            <form method="POST">
                                <input type="hidden" value="Check out" name="action">
                                <input type="submit" value="Delete">
                            </form>

                        </td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>

    </body>
</html>
