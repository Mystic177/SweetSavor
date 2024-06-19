<!DOCTYPE html>
<html>

<!-- Creare il redirect della pagina verso admin login
Check pw (se == admin data redirect-> admin view/page)
-->
    <head>
        <title>Admin Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./CSS/admin.css"  type="text/css">            
        
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="./Javascript/async.js"></script>
    </head>

    <body>
    
        <!-- update AJAX -->
        <aside>
            <div class="sidebar">
                <h1>Dashboard</h1>
                <ul class="menu">
                    <li><a href="stats.html">Dati analitici</a></li>
                    <li><a href="stats.html">Prodotti</a></li>
                    <li><a href="stats.html">Ordini</a></li>
                    <li><a href="stats.html">Recensioni </a></li>
                    <li><a href="stats.html">Transazioni</a></li>
                    <li><a href="Upload.jsp">Aggiungi un prodotto</a></li>
                </ul>
                <button type="submit" onclick="loadDoc()">BOTTONE</button>
            </div>
        </aside>

        <div class="home-box">
            <div class="earnings-box">
                    <h4>Guadagni Mensili</h4>
                    <span id="money">$4,231.45</span>
            </div>

            <div class="sales">
                <h4>Vendite Suca</h4>
                <span id="money">4532</span>
            </div>
        </div>

        <!-- <div class="mainHomeBlock">
            <div class="sub-container">
                <div class="earning">
                    <div class="box-1">

                    </div>
                </div>      
            </div>
        </div> -->

            


    </body>
</html>