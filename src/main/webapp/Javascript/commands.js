
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


//funzione per la ricerca sul sito
function ricercaOggetti(){
    var input = document.getElementById("search-bar-id");

    alert("suca");
    
}