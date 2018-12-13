<%-- 
    Document   : editproduct
    Created on : Dec 12, 2018, 8:59:36 AM
    Author     : TRINH_PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                </tr>
            </thead>
            <tbody>
                <tr>
            <form method="POST">
                <td>
                    <input type="text" value="${products.productID}" name="productID"> 
                </td>
                <td>
                    <input type="text" value="${products.productCode}" name="productCode"> 
                </td>
                <td>
                    <input type="text" value="${products.productDescription}" name="productDescription"> 
                </td>
                <td>
                    <input type="text" value="${products.productPrice}" name="productPrice"> 
                </td>
                <td>  
                    <input type="submit" value="Edit product value" name="action"/>
                </td>
            </form>
        </tr>
    </tbody>
</table>

</body>
</html>
