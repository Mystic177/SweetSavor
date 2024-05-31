<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="it">
<head>
    <title>Registrati</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/registration.css" type="text/css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>

<header>
    <img id="cup" src="./img/SweetSavor.png">
</header>

<div class="container">
    <h1>Registrati</h1>

    
    <form action="register" method="post">
        <div class="nameInput">
            <input type="text" placeholder="Nome" id="username" name="username" required>
            <i class='bx bxs-user'></i>
        </div>

        <div class="mailInput">
            <input type="email" placeholder="Email" id="email" name="email" required>
            <i class='bx bxs-envelope'></i>
        </div>

        <div class="password">
            <input type="password" placeholder="Password" id="password" name="password" required>
            <i class='bx bxs-lock-alt'></i>
        </div>

        <div class="indirizzo">
            <input type="text" placeholder="Indirizzo" id="address" name="address" required>
            <i class='bx bxs-map'></i>
        </div>

        <div class="terms">
            <label><input type="checkbox" required>Accetto i <a href="#">Termini e Condizioni</a></label><br><br>
            <label><input type="checkbox">Iscriviti alla <a href="#">Newsletter</a></label>
        </div>

        <button type="submit" class="btn">Iscriviti</button>
    </form>

    <hr style="width:100%;text-align:left;margin-left:50px">

    <div class="loginWith">
        <button type="button" class="btn">
            <i class='bx bxl-google'></i> Continua con Google
        </button>
        <button type="button" class="btn">
            <i class='bx bxl-facebook'></i> Continua con Facebook
        </button>
    </div>
</div>

</body>
</html>
