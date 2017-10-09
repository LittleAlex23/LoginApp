<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="css/InlineTag.css">
    <body> 
        <%
            if(request.getAttribute("invalid") != null)
                out.println(request.getAttribute("invalid"));
        %>
        <div>
            <form action="AccountServlet" method="POST" align="center">
                <fieldset id="box">
                    <table>
                        <tr>
                            <td align="right">username:</td> 
                            <td><input type="text" name="username" maxlength="12"></td>
                        </tr>
                        <tr>
                            <td align="right"> password:</td>  
                            <td><input type="password" name="pass" maxlength="12"></td> 
                        </tr>
                        <tr>
                            <td></td> 
                            <td align="right"><input type="submit" name="login" value="log in"></td> 
                        </tr>
                        <tr>
                            <td></td> 
                            <td align="right"><a href="CreateAccount.jsp"> create new account </a></td>
                         </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>
