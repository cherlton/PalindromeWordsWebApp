<%-- 
    Document   : outcome
    Created on : 09 Mar 2024, 5:24:24 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <%
            String word = (String)request.getAttribute("word");
            String reverseForm = (String)request.getAttribute("reverseForm");
            boolean isPalindrome = (Boolean)request.getAttribute("isPalindrome");
        %>
        <p>
            Below is the outcome.
        </p>
        <table>
            <tr>
                <td>Entered word: </td>
                <td><b><%=word%></b></td>
            </tr>
            <tr>
                <td>Reverse form: </td>
                <td><b><%=reverseForm%></b></td>
            </tr>
            <tr>
                <td>Is word a palindrome? </td>
                <td><b><%=isPalindrome%></b></td>
            </tr>
        </table>
        <p>
            Click <a href="word_entry.html">here</a> to enter another word or <a href="summary.jsp">here</a> to display the summary.
        </p>
    </body>
</html>
