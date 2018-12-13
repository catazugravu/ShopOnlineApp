<%-- 
    Document   : addproduct
    Created on : Dec 11, 2018, 3:03:33 PM
    Author     : TRINH_PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>ProductCode</th>
                    <th>ProductDescription</th>
                    <th>ProductPrice</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="products" items="${products}">
                <tbody>
                    <tr>
                        <td>${products.productID}</td>
                        <td>${products.productCode}</td>
                        <td>${products.productDescription}</td>
                        <td>${products.productPrice}</td>
                        <td>
                            <form method="POST">
                                <input type="hidden" value="${products.productID}" name="productID"/>
                                <input type="submit" value="Edit product" name="action"/>
                            </form>
                        </td>
                        <td>     
                            <form method="POST">
                                <input type="hidden" value="${products.productID}" name="productID"/>
                                <input type="submit" value="Delete" name="action"/>
                            </form>
                        </td>
                       
                    </tr>
                </tbody>
            </c:forEach>    
            <tbody>
                <tr>
            <form method="POST">
                <td>
                    <input type="text" value="Product ID" name="productID"/>
                </td>
                <td>
                    <input type="text" value="Product Code" name="productCode"/>
                </td>
                <td>
                    <input type="text" value="Product Description" name="productDescription"/>
                </td>
                <td>
                    <input type="text" value="Product Price" name="productPrice"/>
                </td>
                <td>
                    <input type="submit" value="Add product" name="action"/>
                </td>
                <td></td>
            </form>
        </tr>
    </tbody>
</table>
</body>
</html>
