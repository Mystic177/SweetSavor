<%@ page import="model.Prodotto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Carrello</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet" href="../CSS/cart.css">
    <script src="../Javascript/cart.js" defer></script>
    <script src="../Javascript/admin.js" defer></script> <!-- Importa admin.js come file esterno -->
    <style>
        /* Stili CSS aggiuntivi possono essere inclusi qui */
    </style>
</head>
<body>

<%
    // Otteniamo le variabili dalla servlet
    ArrayList<Prodotto> listaProdotti = (ArrayList<Prodotto>) request.getAttribute("listaProdotti");
    Integer totalProdotti = (Integer) request.getAttribute("totalProdotti");
    Double totalImporto = (Double) request.getAttribute("totalImporto");
    String message = (String) request.getAttribute("message");
%>

<div class="cart-container">
    <%
        if (listaProdotti != null && !listaProdotti.isEmpty()) {
    %>
    <script src="/Javascript/control.js"></script>
    <div class="product-list" id="cart-list">
        <h2>Carrello</h2>

        <form id="cart-form" action="<%= request.getContextPath() %>/cart" method="post">
            <% for (int i = 0; i < listaProdotti.size(); i++) { %>
            <div class="product-item">
                <div class="image-box">
                    <img src="<%= listaProdotti.get(i).getImg() %>" height="100">
                </div>
                <div class="product-info">
                    <p>Nome Prodotto: <%= listaProdotti.get(i).getDescrizione() %></p>
                    <p>Prezzo: €<%= listaProdotti.get(i).getPrezzo() %></p>
                    <div class="quantity">
                        <label for="quantity_<%= i %>">Quantità:</label>
                        <input type="number" id="quantity_<%= i %>" name="quantity" class="quantity-input" value="<%= listaProdotti.get(i).getQuantita() %>" min="1" max="10" data-index="<%= i %>">
                        <input type="hidden" name="productId" value="<%= listaProdotti.get(i).getId() %>">
                    </div>
                    <p class="availability">Disponibilità: <span class="in-stock">In Stock</span> <i id="check-i" class="fa-solid fa-check"></i></p>
                    <button type="button" class="remove-button" onclick="removeProduct(this)">Rimuovi</button>
                </div>
            </div>
            <% } %>
            <button type="submit">Aggiorna Quantità</button>
        </form>

    </div>

    <div class="checkout-box">
        <div class="content-box">
            <h2>Riepilogo Ordine</h2>
            <p>Totale Prodotti: <%= totalProdotti %></p>
            <p>Totale Importo: €<%= totalImporto %></p>
            <a href="checkout.jsp"><button id="checkout-button">Procedi al Pagamento</button></a>
        </div>
    </div>
    <% } else { %>
    <p><%= message %></p>
    <% } %>
</div>

<%@ include file="../fragments/footer.jsp" %>
<style><%@ include file="../CSS/home.css" %></style>

<script src="/Javascript/cart.js" >

</script>

</body>
</html>
