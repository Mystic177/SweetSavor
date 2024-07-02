<!-- admin.jsp -->
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin E-commerce</title>
    <link rel="stylesheet" href="../CSS/admin.css">
</head>
<body>
<div class="header">
    <h1>Pagina Admin</h1>
</div>
<div class="container">
    <div class="sidebar">
        <a href="addProduct.jsp" class="sidebar-link" data-url="addProduct.jsp">Aggiungi Prodotti</a>
        <a href="viewOrders.jsp" class="sidebar-link" data-url="viewOrders.jsp">Controlla Ordini</a>
        <a href="modifyProduct.jsp" class="sidebar-link" data-url="modifyProduct.jsp">Modifica Prodotti</a>
        <a href="currentProducts.jsp" class="sidebar-link" data-url="currentProducts.jsp">Prodotti Presenti</a>
        <a href="deleteProduct.jsp" class="sidebar-link" data-url="deleteProduct.jsp">Elimina prodotti</a>
    </div>
    <div class="main" id="content">
        <!-- parte dove viente caricato il  contenuto dinamico -->
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="admin.js"></script>
</body>
</html>
