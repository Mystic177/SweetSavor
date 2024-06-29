document.addEventListener('DOMContentLoaded', function() {
    // Carica la sezione di default
    loadSection('jsp/addProduct.jsp');

    // Gestisce il clic sui link della sidebar
    document.querySelectorAll('.sidebar-link').forEach(function(link) {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            var url = this.getAttribute('data-url');
            loadSection(url);
        });
    });
});

function loadSection(url) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);

    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            document.getElementById('content').innerHTML = xhr.responseText;
        } else {
            console.error('Errore caricamento:', xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('Errore caricamento:', xhr.statusText);
    };

    xhr.send();
}
