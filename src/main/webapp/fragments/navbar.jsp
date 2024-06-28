<html>
<head>

  <meta name="viewport" content="initial-scale=1, width=device-width">
  <link rel="stylesheet" href="./CSS/home.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="../CSS/home.css">
</head>
<body>
<script src="Javascript/commands.js"></script>

<header>
  <img id="cup" src="./img/SweetSavor.png">
</header>

<div class="nav-bar">
<ul class="menu">

  <li><a href="cioccolate.jsp">CIOCCOLATA</a></li>
  <li><a href="te.jsp">TÉ</a></li>
  <li><a href="tisane.jsp">TISANE</a></li>
  <li><a href="accessori.jsp">ACCESSORI</a></li>
  <li><a href="regali.jsp">REGALI</a></li>


  <ul class="user-interaction-box">
    <li><a href="login.jsp">Login<i class='bx bxs-user' id="accBox"></i></a></li>

    <form action="search"  method="get" onsubmit="ricercaOggetti()" id="search-bar-id">
    <div class="searchBarBox" >
      <input type="text" placeholder="Ricerca"   name="search-bar-input" class="searchBar" >
      <i class='bx bx-search'></i>
    </div>
</form>
    <div class="cart-icon">
      <a href="cart.jsp"><i class='bx bx-cart-add'></i></a>
    </div>

  </ul>

</ul>


</div>
</body>
</html>
