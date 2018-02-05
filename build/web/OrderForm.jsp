<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order form</title>
    </head>
    <body>
        <form action="/WebApp/OrderServlet" method="POST" style="background:#AAAAAA; width:295px; margin:auto;">

            <table>
                <tr>
                    <td>
                        Enter first name: 
                    </td>
                    <td>
                        <input type = "text" name = "firstName" placeholder = "last"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender: 
                    </td>
                    <td>
                        <input type = "radio" name = "gender" value="male"> male
                        <input type = "radio" name = "gender" value="female"> female
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align:top">Description:
                    </td>	
                    <td>
                        <textarea rows = "5" columns = "10" name = "text">Enter Description.
                        </textarea>
                    </td>
                </tr>
            </table>
            <input type = "checkbox" name = "checkbox"> checkbox <br>
            <select name="person">
                <option> item 1 </option>
                <option > item 2 </option>
                <option > item 3 </option>
            </select><br>
            <input type = "submit" name = "submitButton" value="login"><br>
        </form>
    </body>
</html>
