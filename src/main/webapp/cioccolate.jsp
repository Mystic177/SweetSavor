<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.ProdottoDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cioccolata</title>
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet" href="./CSS/productpage.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://kit.fontawesome.com/54779b1c8e.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="home-container">
    <!-- Showcase prodotti -->
    <%
        ArrayList<Prodotto> lista = new ArrayList<>();
        ProdottoDao prodottoDao = new ProdottoDao();
        try {
            lista = prodottoDao.doRetrieveAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lista != null && !lista.isEmpty()) {
            for (Prodotto prodotto : lista) {
    %>
    <div class="product-item">
        <h2><%= prodotto.getDescrizione() %></h2>
        <p>Prezzo: <%= prodotto.getPrezzo() %>€</p>
        <p>Disponibilità: <%= prodotto.getDisponibility() %></p>
        <p>Categoria: <%= prodotto.getCategoria() %></p>
        <img src="<%= prodotto.getImg() %>" alt="<%= prodotto.getDescrizione() %>" />
    </div>
    <%
        }
    } else {
    %>
    <p>Nessun prodotto disponibile al momento.</p>
    <%
        }
    %>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>
