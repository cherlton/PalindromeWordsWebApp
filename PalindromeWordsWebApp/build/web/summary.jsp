<%-- 
    Document   : summary
    Created on : 09 Mar 2024, 5:34:39 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <%
            int cnt = (Integer)session.getAttribute("cnt");
            int numPalindromes = (Integer)session.getAttribute("numPalindromes");
        %>
        <p>
            Below is the summary.
        </p>
        <table>
            <tr>
                <td>Number of words checked: </td>
                <td><b><%=cnt%></b></td>
            </tr>
            <tr>
                <td>Number of palindromes: </td>
                <td><b><%=numPalindromes%></b></td>
            </tr>
        </table>
        <p>
            Click <a href="word_entry.html">here</a> to enter another word or <a href="EndSessionServlet.do">here</a> to end session.
        </p>        
    </body>
</html>
