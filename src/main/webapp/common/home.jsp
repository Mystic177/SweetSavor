<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SweetSavor</title>
        <meta name="viewport" content="initial-scale=1, width=device-width">
        <link rel="stylesheet" href="../CSS/home.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
    
            <%@include file="/fragments/header.jsp" %>
           
            <!-- Container home 
               String productLink = request.getContextPath() + "/prodotto.jsp?name=" + URLEncoder.encode(prodotto.getNomeProdotto(), "UTF-8");-->
            <div class="home-container">

                <h1 class="home-header">GLI ULTIMI PRODOTTI</h1>
                <!-- Showcase prodotti -->
                
                <div class="image-container">
                    <a href="Pagina1.html"><img src="<%= request.getContextPath() %>/img/chocolate%201.png" class="productImage" ></a>
                    <a href="Pagina1.html"><img src="<%= request.getContextPath() %>/img/tisana%20(6).png" class="productImage" ></a>
                    <a href="Pagina1.html"><img src="<%= request.getContextPath() %>/img/tisana%20(7).png" class="productImage" ></a>
                </div>


                <h1 class="home-header">LE NUOVE TISANE</h1>

                <div class="image-container">
                    <!-- Far combaciare la tisana con la pagina del prodotto -->
                    <a href="paginatisane"><img src="../img/tisana%20(1).png" class="productImage"></a>
                    <a href="paginatisane"><img src="../img/tisana%20(2).png" class="productImage"></a>
                    <a href="paginatisane"><img src="../img/tisana%20(3).png" class="productImage"></a>
                    
                </div>

                </div>
            </div>


    <%@include file="/fragments/footer.jsp" %>
    </body>
</html>