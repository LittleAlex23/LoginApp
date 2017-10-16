<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/InlineTag.css" />' />
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/globalDecor.css" />' />
    </head>
    <body>
        <jsp:useBean id = "user" class="Entity.UserAccount" scope="session"> 
        </jsp:useBean>
        <a href="LoginSuccess.jsp">return to home</a>
        <form action="AccountServlet" method="POST" id="profileForm">
            <fieldset id="box">
                <legend>Edit profile</legend>
                <table>
                    <tr>
                        <td>
                            Description:
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <textarea rows="10" cols="50" name="edit_text" form="profileForm"maxlength="65535"><%= user.getDescription() %>
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td align ="right"><input type="submit" value="save"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
