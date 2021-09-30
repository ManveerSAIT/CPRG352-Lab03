<%-- 
    Document   : arithmeticcalculator
    Created on : Sep 30, 2021, 1:38:57 PM
    Author     : manve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
        <label>First: </label>
        <input type="text" name="first_value" value="${firstInt}">
        <br>
        <label>Second: </label>
        <input type="text" name="second_value" value="${secondInt}">
        <br>
        <input type="submit" name="calc" value="+">
        <input type="submit" name="calc" value="-">
        <input type="submit" name="calc" value="*">
        <input type="submit" name="calc" value="%">
        <h4>Result: ${resultOutput}</h4>
        <a href="/Lab03/age">Age Calculator</a>
        </form>
    </body>
</html>
