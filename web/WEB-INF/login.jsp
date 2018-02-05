<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log-in Page</title>
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/InlineTag.css" />'>
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/globalDecor.css" />' />
    </head>
    <body> 
        <a href="index.html"> main page </a>
        <div class="error_Input" align="center">
        <%
            if(request.getAttribute("invalid") != null)
                out.println(request.getAttribute("invalid"));
        %>
        </div>
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
                            <td align="right"><input type="submit" name="execute" value="log_in"></td> 
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
