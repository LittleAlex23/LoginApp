<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/InlineTag.css" />' />
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/globalDecor.css" />' />
    </head>
    <body>
        <a href="LoginSuccess.jsp">return to home</a>
        <br>
        <div class="error_Input">
        <%
            if(session.getAttribute("user") == null){
                response.sendRedirect("/TestLogin/start");
                return;
            }
            HashMap<Integer,String> messageList = (HashMap<Integer,String>)request.getAttribute("errorMessage");
            if(messageList != null && !messageList.isEmpty()){
                String message = null;
                if((message = messageList.get(0)) != null){
                    out.println(message);
                
        %>
        <br>
        <%      }
                else if((message = messageList.get(1)) != null)
                    out.println(message);
            }
        
        
        %>
        </div>
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
