<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/InlineTag.css">
        <link rel="stylesheet" type="text/css" href="css/globalDecor.css">
    </head>
    <body>
        <a href="LoginSuccess.jsp">return to home</a>
        <br>
        <%
            if(session.getAttribute("user") == null){
                response.sendRedirect("/TestLogin/start");
                return;
            }
            String old = (String)request.getAttribute("error");
            if(old != null)
                out.println(old);
        %>
        <br>
        <%
            String newPass = (String)request.getAttribute("invalidPassword");
            if(newPass != null)
                out.println(newPass);
        %>
        <form action="AccountServlet" method="POST">
            <fieldset id="box">
                <legend>Edit account:</legend>
                <table>
                    <tr>
                        <td>Enter old password:</td>
                        <td><input type="password" name="old_password"></td>
                    </tr>
                    <tr>
                        <td>Change password:</td> 
                        <td><input type="password" name="new_password"></td></tr>
                    <tr>
                        <td>Change email:</td>
                        <td><input type="text" name="new_email"></td>
                    </tr>
                    <tr>
                        <td></td><td align ="right"><input type="submit" name="edit_account" value="save"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
