<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage = "error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/globalDecor.css">
        <link rel="stylesheet" type="text/css" href="css/HomePage.css">
        <script src="js/EditButtonScript.js"></script>
        <style>
            ul{
                margin: 0px;
                padding:0px;
                text-align: left;
            }
            li{
                margin-left: 10px;
                display:inline;
            }
        </style>
    </head>
    <body> 
        <jsp:useBean id = "user" class="Entity.UserAccount" scope="session"> 
        </jsp:useBean>
        <ul>
            <li><a href = "AccountServlet"> log out </a> </li>
            <li><a href = "DeleteAccount.html"> delete account </a></li>
            <li> <a href = "EditAccount.jsp"> edit account </a></li>
            <li> active visitors: <%= session.getAttribute("currentVisitorCount")%> </li>
        </ul>
        <div id="main">
            <h1>Welcome, <%= user.getName()%></h1>
            You are visitor #<%= session.getAttribute("overAllUserCount")%>!
            <div id = "profile">
                <table>
                    <tr>
                        <td>
                            rank: <%= user.getRank()%>
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td align ="right">
                            <a href="EditProfile.jsp">edit profile</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form>
                                <legend align="left">Description:</legend>
                                <textarea rows="10" cols="50" class="edit" maxlength="65535" readonly><%= user.getDescription()%> </textarea>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
