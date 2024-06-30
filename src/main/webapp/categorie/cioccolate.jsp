<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.ProdottoDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cioccolata</title>
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet" href="../CSS/productpage.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://kit.fontawesome.com/54779b1c8e.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../fragments/header.jsp" %>

<div class="home-container">
    <!-- Showcase prodotti -->
    <%
        ArrayList<Prodotto> lista = null;
        ProdottoDao prodottoDao = new ProdottoDao();
        System.out.println("D1");

        try {
            lista = prodottoDao.doRetrieveByCategoria("cioccolata"); // Filtra i prodotti per categoria "cioccolata"
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lista != null && !lista.isEmpty()) {
            for (Prodotto prodotto : lista) {
                if (prodotto.getCategoria().equalsIgnoreCase("cioccolata")) {
    %>
    <div class="product-item">
        <img src="<%= prodotto.getImg() %>" class="productImage" />
        <p><%= prodotto.getNomeProdotto() %></p>
        <p><%= prodotto.getPrezzo() %>&euro;</p>
        <button class="add-to-cart" onclick="addToCart()">Aggiungi al carrello</button>
    </div>
    <%
            }
        }
    } else {
    %>
    <p>Nessun prodotto disponibile al momento.</p>
    <%
        }
    %>
</div>
<%@ include file="../fragments/footer.jsp" %>
</body>
</html>
