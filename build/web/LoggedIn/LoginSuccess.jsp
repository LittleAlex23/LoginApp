<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage = "error.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="../css/globalDecor.css">
        <link rel="stylesheet" type="text/css" href="../css/HomePage.css">
        <script src="http://code.jquery.com/jquery-3.2.1.js"></script>
        <style>
            #header{
                border: solid black 5px;
                background-color: #cccccc;
                position:sticky;
            }
            ul{
                margin: 0px;
                padding:0px;
                text-align: left;
            }
            li{
                padding:5px;
                font-size: 30px;
                margin-left: 10px;
                display:inline;
            }
            #info{
            }
            #main{
                float:left;
                border: solid black 5px;
            }
            #profile{
                float:left;
                border: solid black 5px;
            }
            #game{
                width:100%;
                height:50%;
                float:right;
            }
            #game tr td:hover{
                background-color: red;
            }
        </style>
    </head>
    <body> 
        <jsp:useBean id = "user" class="Entity.UserAccount" scope="session"> 
        </jsp:useBean>
        <div id='header'>
            <ul>
                <li><a href = "../AccountServlet"> log out </a> </li>
                <li><a href = "DeleteAccount.html"> delete account </a></li>
                <li> <a href = "EditAccount.jsp"> edit account </a></li>
                <li> active visitors:  <%= session.getAttribute("currentVisitorCount")%> </li>
                <li> <a href = "Shopping.jsp"> shop </a></li>
            </ul>
        </div>
        <div id="info">
            <div id="main">
                <h1>Welcome,  <%= user.getName()%></h1>
                You are visitor # <%= session.getAttribute("overAllUserCount")%>!
                <br>
                last logged on:  <%= session.getAttribute("lastLogged")%>
            </div>
            <div id = "profile" >
                <table border="1">
                    <tr>
                        <td>
                            rank:  <%= user.getRank()%>
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            score: 
                            <hr>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <table border="1" id="game">
            <tr>
                <td>
                    1
                </td>
                <td>
                    2
                </td>
                <td>
                    3
                </td>
            </tr>
            <tr>
                <td>
                    1
                </td>
                <td>
                    2
                </td>
                <td>
                    3
                </td>
            </tr>
            <tr>
                <td>
                    1
                </td>
                <td>
                    2
                </td>
                <td>
                    3
                </td>
            </tr>
        </table>
    </body>
</html>
