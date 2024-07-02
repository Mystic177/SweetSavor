<%@ page import="model.Prodotto" %>
<%@ page import="model.ProdottoDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SweetSavor</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin E-commerce</title>
    <link rel="stylesheet" href="../CSS/admin.css">
</head>
<body>
    <%
    ProdottoDao dao = new ProdottoDao();
    ArrayList<Prodotto> lista = dao.doRetrieveAll();

        if (lista != null && !lista.isEmpty()) {
            for (Prodotto prodotto : lista) {
    %>
    <div class="main-product-item">
            <img src="data:image/jpeg;base64,<%= new String(Base64.getEncoder().encode(prodotto.getImg())) %>" class="main-productImage" width="150">
            <p class="main-product-name"><%= prodotto.getNomeProdotto() %></p>
            <p class="main-product-price"><%= String.format("%.2f",prodotto.getPrezzo())%> &euro;</p>
        </a>
        <button class="main-add-to-cart" >Modifica il prodotto</button>
    </div>
    <%
        }
    } else {
    %>
    <p class="main-no-products">Nessun prodotto disponibile al momento.</p>
    <%
        }
    %>
    
</body>
</html>
