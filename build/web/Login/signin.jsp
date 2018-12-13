<%-- 
    Document   : signup
    Created on : Dec 12, 2018, 1:44:19 PM
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
        <form>
            <label>Username</label>
            <input type="text" name="username" required><br>
            <label>Password</label>
            <input type="password" name="password" required><br>
            <label>&nbsp;</label>
            <input type="hidden" value="sign in" name="action">
            <input type="submit" value="sign in" id="submit"> 
        </form>
        <form>
            <input type="hidden" value="sign up" name="action">
            <input type="submit" value="Register" id="submit"> 
        </form>
    </body>
</html>
