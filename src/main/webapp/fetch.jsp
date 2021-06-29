<%@ page import="com.ashish.example.springmanydemo.h2.model.Person" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Fetch Page</title>
</head>
<body>

<h2>Update Person</h2>
    <form action="updatePerson">
        ID: <input type="text" name="pid" value="${person.pid}" readonly><br>
        NAME: <input type="text" name="pname" value="${person.pname}"><br>

        Gender: <% Person person = (Person) request.getAttribute("person");
                    if (null != person.getGender() && person.getGender().equalsIgnoreCase("male") ) {%>
                        <input type="radio" name="gender" value="male" checked>  Male
                        <input type="radio" name="gender" value="female" >  Female
                    <%
                    }
                    else if (null != person.getGender() && person.getGender().equalsIgnoreCase("female") ) { %>
                        <input type="radio" name="gender" value="male"> Male
                        <input type="radio" name="gender" value="female"checked> Female
                    <%
                    }
                    else  { %>
                        <input type="radio" name="gender" value="male"> Male
                        <input type="radio" name="gender" value="female"> Female
                    <% } %>
        <br>
        <input type="submit"><br>
    </form>
 <br>
    <a href="/">Home</a>
</form>
</body>
</html>