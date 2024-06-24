
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- addProduct.jsp -->
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8"  content="width=device-width, initial-scale=1.0">
    <title>Aggiungi Prodotti</title>
    <link rel="stylesheet"  href="../CSS/admin.css">
</head>
<body>
<div class="card section">
    <h2>Aggiungi Prodotti</h2>
    <form action="AddProductServlet" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="product-name">Nome Prodotto:</label>
            <input type="text" id="product-name" name="productName">
        </div>
        <div class="form-group">
            <label for="product-description">Descrizione Prodotto:</label>
            <textarea id="product-description" name="productDescription"></textarea>
        </div>
        <div class="form-group">
            <label for="product-price">Prezzo Prodotto:</label>
            <input type="number" id="product-price" name="productPrice" step="0.01">
        </div>
        <div class="form-group">
            <label for="product-stock">Stock Prodotto:</label>
            <input type="number" id="product-stock" name="productStock">
        </div>


        <select name="products" id="product-id-selection"></span><br>
            <option value="051">Cioccolata</option>
            <option value="052">Tisana</option>
            <option value="053">Tè</option>
            <option value="054">Regalo</option>
        </select>
        
        <div class="form-group">
            <br>
            <label for="product-image">Immagine Prodotto:</label>
            <input type="file" id="product-image" name="productImage" class="file-input">
            <button type="button" class="custom-file-button" onclick="document.getElementById('product-image').click()">Scegli File</button>
        </div>


        <div class="form-group">
            <button type="submit" class="custom-file-button">Aggiungi Prodotto</button>
        </div>
    </form>
</div>
</body>
</html>
