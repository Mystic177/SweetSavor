<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="upload.css"  type="text/css">            
        
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="./Javascript/async.js"></script>
    </head>

    <body>
        <header>Admin page </header>
        <div class="upload-file-box">
            <form action="FileUpload" method="post" name="upload-form" >
                <fieldset>

                    <input type="file" multiple class="upload-box">
                    <!-- <label class="custom-file-upload">Carica le immagini</label> -->
                    <label class="custom-file-upload">+</label>
                    <label>Aggiungi immagini</label>
                    
                    <div class="product-info-box">
                        <label>Nome Prodotto</label> <span><input type="text" placeholder="Nome"></span><br>

                        <label>Tipo prodotto</label> <span>
                        <select name="products" id="product-id-selection"></span><br>
                            <option value="051">Cioccolata</option>
                            <option value="052">Tisana</option>
                            <option value="053">Tè</option>
                            <option value="054">Regalo</option>
                        </select><br>

                        <label>Descrizione prodotto</label> 
                        <br><textarea placeholder="Descrizione del prodotto"></textarea>
                        
                    </div>
                </fieldset> 
            </form>
        </div>
    </body>
</html>