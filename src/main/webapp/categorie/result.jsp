<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SweetSavor</title>
    <link rel="stylesheet" type="text/css" href="../CSS/home.css">
</head>
<body>
<%@ include file="../fragments/navbar.jsp" %>

<%
    ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");
    if (listaProdotti != null && !listaProdotti.isEmpty()) {
%>
<ul>
    <%
        for (Prodotto prodotto : listaProdotti) {
    %>
    <li class="product-box">
        <img src="<%= prodotto.getImg() %>" alt="immagine non disponibile">
        <h2><%= prodotto.getNomeProdotto() %></h2>
        <p><%= prodotto.getPrezzo() %> $</p>
    </li>
    <%
        }
    %>
</ul>
<%
} else {
%>
<p>Nessun prodotto trovato</p>
<%
    }
%>

<%@ include file="../fragments/footer.jsp" %>
<style>
    <%@ include file="../CSS/home.css" %>
</style>
</body>
</html>
