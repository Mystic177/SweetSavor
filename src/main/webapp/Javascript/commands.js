
//funnzione per la gestione della compatibilità
function createXMLHttprequest(){
    var request;
    try{
        request = new XMLHttpRequest();
    } catch(e){
        try{
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e){
            try{
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e){
                alert("AJAX non supportato dal browser");
                return null
            }
        }
    }
    return request;
}



function validateRegistrationForm() {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (email.trim() === '' && password.trim() === '' && username.trim() === '') {
        alert("Completare tutti i campi");
        return false; // Non inviare la richiesta
    }

    return true; // Invia la richiesta POST
}

function validateLoginForm() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (email.trim() === '' || password.trim() === '') {
        alert("Completare tutti i campi");
        return false; // Non inviare la richiesta
    }

    return true; // Invia la richiesta POST
}



//funzione  per addToCart
function addToCart() {
    document.addEventListener("DOMContentLoaded", () => {
        const buttons = document.querySelectorAll('.add-to-cart');
        buttons.forEach(button => {
            button.addEventListener('click', () => {
                const productId = button.closest('.product-item').getAttribute('data-id');
                fetch('../AddToCart', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: `productId=${productId}`
                })
                    .then(response => response.text())
                    .then(data => {
                        alert('Prodotto aggiunto al carrello');
                    })
                    .catch(error => {
                        console.error('Errore:', error);
                    });
            });
        });
    });
}