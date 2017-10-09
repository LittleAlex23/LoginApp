<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/globalDecor.css">
    </head>
    <body>
        <a href="start"> return to start</a>
        <br>
        <br>
        <form action="AccountServlet" method="POST">
            <fieldset>
                <%
                    String name = (String)request.getAttribute("accountExisted");
                    if(name != null){
                        out.println(name);
                 %>
                <br>
                <%}%>
                must be at most 12 characters
                <br>
                username: <input type="text" name="username" maxlength="12"> 
                <br>
                <br>
                <%
                    String pass = (String)request.getAttribute("invalidPassword");
                    if(pass != null){
                        out.println(pass);
                         
                %>
                <br>
                <%}%>
                must be at between 3 and 12, have at least 1 symbol, and have at least 1 number 
                <br>
                password: <input type="password" name="pass" maxlength="12">
                <br>
                <br>
                <input type="submit" name ="new_account" value="create account">
                <br>
            </fieldset>
        </form>
    </body>
</html>

