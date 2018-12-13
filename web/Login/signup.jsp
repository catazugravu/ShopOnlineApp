<%-- 
    Document   : Signin
    Created on : Dec 12, 2018, 1:45:28 PM
    Author     : TRINH_PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
    </head>
    <body>
        <form>
            <label>Username</label>
            <input type="text" name="username" required><br>

            <label>Password</label>
            <input type="password" name="password" required><br>

            <label>FirstName</label>
            <input type="text" name="firstName" required><br>  

            <label>LastName</label>
            <input type="text" name="lastName" required><br>  

            <label>Email</label>
            <input type="text" name="email" required><br>  

            <label>CompanyName</label>
            <input type="text" name="companyName" required><br>  

            <label>Address1</label>
            <input type="text" name="address1" required><br>  

            <label>Address2</label>
            <input type="text" name="address2" required><br>  

            <label>City</label>
            <input type="text" name="city" required><br>

            <label>Country</label>
            <input type="text" name="country" required><br>  

            <label>&nbsp;</label>
            <input type="hidden" value="sign up" name="action">
            <input type="submit" value="sign up" id="submit"> 
        </form>
    </body>
</html>
