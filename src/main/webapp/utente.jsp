<%@ page import="DatabaseObjs.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    
    <%!
        User u = new User("Nomo", "Cognomo", "La mail", "indiririr");
    %>
    
</head>
<body>

    <p> <%= u.getAddress()%></p>    

</body>
</html>
