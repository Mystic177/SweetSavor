<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- AGGIUNGERE IMMAGINI MULTIPLE IA -->
        <!-- codice JSP per il titolo in -->
         <!-- Metatags, titolo, CSS, JavaScript, ecc. -->
    <!--tile = getProductName? -->
    
        <title>ProductPage</title>
        <meta name="viewport" content="initial-scale=1, width=device-width">
        <link rel="stylesheet" href="./CSS/prodotto.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://kit.fontawesome.com/54779b1c8e.js" crossorigin="anonymous"></script>
    </head>
    
    <body>

    
    <%@include file="./HtmlElements/navbar.jsp" %>
    
    <script src="./Javascript/commands.js"></script>

        <div class="product-main-box">

            <div class="grid-product-box">

                <div class="image-box">
                    <!-- Aggiungere richiesta product.getImg() -->
                    <img class="mySlides" src="./img/tisana (2).png" height="300">        
                </div>
                
                <div class="user-box">
                    <!-- Da allineare a destr  -->           
                    <div class="product-description">
                        <!-- Aggiungere richiesta product.getAttribute() -->

                        <p>Nome Prodotto</p>
                        
                        <p>Ingredienti </p>
                        <p>Prezzo</p>       
                        <div class="quantity">
                            <label for="quantity">Quantità:</label>
                            <input type="number" id="quantity" name="quantity" value="1" min="1">
                        </div>                   


                        <!-- Controllo back-end  spunta o croce in base alla disponibilità -->
                        <p class="availability">Disponibilità: <span class="in-stock">In Stock</span> <i id="check-i"class="fa-solid fa-check"></i></p>
                        
                        
                    </div>   
                                  
                    <p>Descrizione <br>Un'armoniosa miscela di camomilla rilassante, lavanda profumata e melissa calmante, danza di aromi sotto la luce argentea della serata. Una carezza alla mente, perfetta per distendersi dopo una lunga giornata.</p>
                    <form action="#">
                        <button id="buy-button" onclick="buyProduct()">Aggiungi al carrello </button>
                        <button id="buy-button" onclick="">Aggiungi alla wishlist </button>
                    </form>

                </div>
                        
                  
               


            </div>
        </div>
        <%@include file="./HtmlElements/footer.jsp"%>
        <style><%@include file="./CSS/home.css"%></style>

        
    </body>
</html>

<!-- <script>
$(document).ready(function(){
    $(".container").on({
    
        mouseenter: function(){
            $(this).css("background-color", "black");
        },  
        
        mouseleave: function(){
            $(this).css("background-color", "#000c4b");
        }, 
        
        click: function(){
            $(this).css("background-color", "#109e2c");
        }
       
    });
});
</script> -->