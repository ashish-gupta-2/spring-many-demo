<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
</head>
<body>
<div>
    <h2>Add Person</h2>
<form action="addPerson">
    ID: <input type="text" name="pid"><br>
    NAME: <input type="text" name="pname"><br>
    Gender: <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female

    <br>
    <input type="submit"><br>
</form>
</div>

<br>
<div style="background-color: #c4fff5" b>
    <h2>Find Person</h2>
<form action="findPerson">
    ID: <input type="text" name="pid"><br>
    <input type="submit"><br>
</form>

</div>

<br>
<div>
    <h2>Delete Person</h2>
    <form action="deletePerson">
        ID: <input type="text" name="pid"><br>
        <input type="submit"><br>
    </form>

</div>

</body>
</html>