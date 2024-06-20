// admin.js
$(document).ready(function() {
    // Carica la sezione di default
    loadSection('jsp/addProduct.jsp');

    // Gestisce il clic sui link della sidebar
    $('.sidebar-link').on('click', function(e) {
        e.preventDefault();
        var url = $(this).data('url');
        loadSection(url);
    });
});

function loadSection(url) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function(response) {
            $('#content').html(response);
        },
        error: function(xhr, status, error) {
            console.error('Errore caricamento:', error);
        }
    });
}
