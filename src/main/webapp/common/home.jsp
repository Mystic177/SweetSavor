<%@ page import="model.Prodotto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProdottoDao" %>
<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>SweetSavor</title>
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/home.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
        <%@include file="/CSS/fragments.css" %>
    </style>
    <script src="<%= request.getContextPath() %>/Javascript/loginStatus.js"></script>
<body>

<%@include file="/fragments/header.jsp" %>

<div class="home-container">

    <h1 class="home-header">GLI ULTIMI PRODOTTI</h1>
    <!-- Showcase prodotti di categoria cioccolata -->
    <%
        ArrayList<Prodotto> listaCioccolata = null;
        ArrayList<Prodotto> listaTisane = null;
        ProdottoDao prodottoDao = new ProdottoDao();

        try {
            listaCioccolata = prodottoDao.doRetrieveByCategoria("cioccolata"); // Recupera prodotti categoria cioccolata
            listaTisane = prodottoDao.doRetrieveByCategoria("tisana"); // Recupera prodotti categoria tisana
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostra i prodotti di categoria cioccolata
        if (listaCioccolata != null && !listaCioccolata.isEmpty()) {
            for (Prodotto prodotto : listaCioccolata) {
    %>
    <div class="image-container">
        <a href="<%= request.getContextPath() %>/categorie/prodotto.jsp?nome=<%= prodotto.getNomeProdotto() %>">
            <img src="data:image/jpeg;base64,<%= new String(Base64.getEncoder().encode(prodotto.getImg())) %>" class="main-productImage" width="150">
            <p><%= prodotto.getNomeProdotto() %></p>
        </a>
    </div>
    <%
            }
        }
    %>

    <h1 class="home-header">LE NUOVE TISANE</h1>
    <%
        // Mostra i prodotti di categoria tisana
        if (listaTisane != null && !listaTisane.isEmpty()) {
            for (Prodotto prodotto : listaTisane) {
    %>
    <div class="image-container">
        <a href="<%= request.getContextPath() %>/categorie/prodotto.jsp?nome=<%= prodotto.getNomeProdotto() %>">
            <img src="data:image/jpeg;base64,<%= new String(Base64.getEncoder().encode(prodotto.getImg())) %>" class="main-productImage" width="150">
            <p><%= prodotto.getNomeProdotto() %></p>
        </a>
    </div>
    <%
            }
        }
    %>

</div>

<%@include file="/fragments/footer.jsp" %>

</body>
</html>
