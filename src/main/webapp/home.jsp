<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta name="viewport" content="initial-scale=1, width=device-width">
        <link rel="stylesheet" href="./CSS/home.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
    
            <%@include file="./fragments/navbar.jsp" %>
        <style><%@include file="./CSS/home.css"%></style>
            
            <!-- Container home -->
            <div class="home-container">

                <h1 class="home-header">GLI ULTIMI PRODOTTI</h1>
                <!-- Showcase prodotti -->
                <div class="image-container">
                    <a href="Pagina1.html"><img src="./img/chocolate 1.png" class="productImage" ></a>
                    <a href="Pagina1.html"><img src="./img/tisana (6).png" class="productImage" ></a>
                    <a href="Pagina1.html"><img src="./img/tisana (7).png" class="productImage" ></a>
                    
                </div>

                <h1 class="home-header">LE NUOVE TISANE</h1>

                <div class="image-container">
                    <!-- Far combaciare la tisana con la pagina del prodotto -->
                    <a href="paginatisane"><img src="tisana (1).png" class="productImage"></a>
                    <a href="paginatisane"><img src="tisana (2).png" class="productImage"></a>
                    <a href="paginatisane"><img src="tisana (3).png" class="productImage"></a>
                    
                </div>



                </div>
            </div>

        <div class="home-container">
            <div class="rows-box">
                <!-- row1 -->
                <div class="rows-1">
                    <div class="image-container">
                        <!-- Far combaciare la tisana con la pagina del prodotto -->
                        <a href="paginatisane"><img src="tisana (1).png" class="productImage"></a>
                        <a href="paginatisane"><img src="tisana (2).png" class="productImage"></a>
                        <a href="paginatisane"><img src="tisana (3).png" class="productImage"></a>
                        
                    </div>
                </div>
                <!-- row2  -->
                <div class="rows-1">
                    <div class="image-container">
                        <!-- Far combaciare la tisana con la pagina del prodotto -->
                        <a href="paginatisane"><img src="tisana (1).png" class="productImage"></a>
                        <a href="paginatisane"><img src="tisana (2).png" class="productImage"></a>
                        <a href="paginatisane"><img src="tisana (3).png" class="productImage"></a>
                        
                    </div>
                </div>


            </div>
        </div>


    <%@include file="./fragments/footer.jsp" %>
    <style><%@include file="./CSS/home.css"%></style>
    </body>
</html>