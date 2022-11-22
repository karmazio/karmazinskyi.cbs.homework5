<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Diary</title>
</head>
<body>
<form method="get" action="/all">
    <input type="submit" value="Find all notes">
</form>
${notes}
<hr>
<h4>To add new note to diary press "Add"</h4>
<form method="post" action="/add">

    <p><label for="date">Date </label></p>
    <p><input type="text" name="date" id="date"></p>
    <br/>

    <p><label for="note">Note </label></p>
    <p><input type="text" name="note" id="note"></p>
    <br/>


    <input type="submit" value="Add">
</form>
<hr>

<h4>Delete note by id:</h4>
<form method="post" action="/delete">
    <p><label for="idToDelete">Id </label></p>
    <p><input type="number" name="idToDelete" id="idToDelete"></p>
    <br/>

    <input type="submit" value="Delete">
</form>
<hr>

<h4>Update note by id</h4>
<form method="post" action="/update">

    <p><label for="idToUpdate">Id of note to update </label></p>
    <p><input type="number" name="idToUpdate" id="idToUpdate"></p>
    <br/>

    <p><label for="dateToUpdate">New date </label></p>
    <p><input type="text" name="dateToUpdate" id="dateToUpdate"></p>
    <br/>

    <p><label for="noteToUpdate">New note </label></p>
    <p><input type="text" name="noteToUpdate" id="noteToUpdate"></p>
    <br/>


    <input type="submit" value="Update">
</form>

</body>
</html>
