<%@ page import="model.Cart" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Carrello</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet" href="../CSS/cart.css">
</head>
<body>
<script src="../Javascript/cart.js"></script>
<!-- Cart cart = (Cart) request.getSession().getAttribute("cart");-->
<%    
    Cart cart1 = new Cart();
    Prodotto prod = new Prodotto("T-shirt blu", 29.99, 50, true, "ABC Fashion", "Abbigliamento", "chocolate.png");
    cart1.addprodotto(prod);
    
    if(cart1 != null && !cart1.isEmpty()) {
%>

<div class="cart-container">
<!-- Inizio jsp2 -->
<%
    

 
    List<Prodotto> listaProdotti = cart1.getListaProdotti();
    

    for(Prodotto prodotto : listaProdotti) {
%>
<!-- Codice JSP per recuperare gli elementi del carrello -->

    <!-- Sezione carrello prodotti -->
    <div class="product-list" id="cart-list">
        <h2>Carrello</h2>
        <div class="product-item">
            <div class="image-box">
                <img src="<%= prodotto.getImg() %>" height="100">
            </div>
            <div class="product-info">
                <p>Nome Prodotto: <%= prodotto.getDescrizione() %></p>
                <p>Prezzo: €<%= prodotto.getPrezzo() %></p>
                <div class="quantity">
                    <label for="quantity">Quantità: <%= prodotto.getDisponibility() %></label>
                    <input type="number" id="quantity" name="quantity" value="1" min="1" max="10">
                </div>
                <p class="availability">Disponibilità: <span class="in-stock">In Stock</span> <i id="check-i" class="fa-solid fa-check"></i></p>
                <button class="remove-button" name="remove-button">Rimuovi </button>
            </div>
        </div>
    </div>
    <!-- Fine product-list -->
</div>
<%
    }
%>
<!-- Fine del loop for -->

<!-- Sezione box di pagamento -->
<div class="checkout-box">
    <div class="content-box">
        <h2>Riepilogo Ordine</h2>
        <p>Totale Prodotti: <%= listaProdotti.size() %></p>
        <p>Totale Importo: €<%= cart1.getTotalPrize() %></p>
        <a href="checkout.jsp"><button id="checkout-button">Procedi al Pagamento</button></a>
    </div>
</div>
<!-- Fine checkout-box -->

<%
} else {
%>
<p>Il carrello è vuoto.</p>
<%
    }
%>

<%@ include file="../fragments/footer.jsp" %>
<style><%@ include file="../CSS/home.css" %></style>

</body>
</html>
