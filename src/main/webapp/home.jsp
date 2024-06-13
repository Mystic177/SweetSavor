<%@ page import="DatabaseObjs.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Codice JSP-->
<%
    User user = (User) request.getSession().getAttribute("user");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1, width=device-width">
        <link rel="stylesheet" href="CSS/home.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
            <header>
            <img id="cup" src="./img/SweetSavor.png">
        </header>
    <% 
        if (user != null && user.loggedIn()){
    %> <p>Benvenuto <%= user.getUsername()%></p>            
   
   <% } else { %>
        <p>Non sei registrato? <a href="registration.jsp">Registrati!</a></p>
   <% } %>
   
        <div class="nav-bar">
            <ul class="menu">
                <li><a href="index.html">HOME</a></li>
                <li class="has-submenu">
                    <a href="TeaPage.html">TÈ</a>
                    <div class="submenu">
                        <a href="#">Te' Nero</a>
                        <a href="#">Te' Verde</a>
                        <a href="#">Te' Esotici</a>
                    </div>
                </li>
            
                <li><a href="TeaPage.html">CIOCCOLATA</a></li>
                <li><a href="TeaPage.html">TISANE</a></li>
                <li><a href="TeaPage.html">ACCESSORI</a></li>
                <li><a href="TeaPage.html">REGALI</a></li>
                

                <ul class="user-interaction-box">
                    <li><a href="login.html"><i class='bx bxs-user' id="accBox"></i></a></li>

                    <div class="searchBarBox">
                        <input type="text" placeholder="Ricerca" class="searchBar">
                        <i class='bx bx-search'></i>
                    </div>
                    
                    <div class="cart-icon">
                        <a href="carrello.html"><i class='bx bx-cart-add'></i></a>
                    </div>

                </ul>

            </ul>
                       
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


        <footer>
            <div class="footer-container">
                <div class="footer-section about">
                    <h2>Chi siamo</h2>
                    <p>Vieni a scoprirci in <br> Via Il Viale Del Negozio 10</p>
                </div>
                <div class="footer-section links">
                    <h2>Link</h2>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Blog</a></li>
                    </ul>
                </div>
                <div class="footer-section social">
                    <h2>Follow Us</h2>
                    <div class="social-icons">
                        <a href="#"><i class='bx bxl-facebook'></i></a>
                        <a href="#"><i class='bx bxl-twitter'></i></a>
                        <a href="#"><i class='bx bxl-instagram'></i></a>
                        <a href="#"><i class='bx bxl-linkedin'></i></a>
                    </div>
                </div>
            </div>
            <div class="footer-bottom">
                &copy; 2024 Sweet Savor. Tutti i diritti riservati.
            </div>
        </footer>
    </body>
</html>