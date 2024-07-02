// Questo codice viene salvato nel file form-validation.js

document.addEventListener('DOMContentLoaded', function() {
    const forms = document.querySelectorAll('.product-form, .contact-form');

    forms.forEach(form => {
        form.addEventListener('submit', function(event) {
            event.preventDefault();

            if (validateForm(form)) {
                const formData = new FormData(form);

                console.log('Invio del form:', formData);

                form.reset();
            } else {
                alert('Si prega di compilare correttamente tutti i campi.');
            }
        });
    });

    function validateForm(form) {
        const requiredInputs = form.querySelectorAll('[required]');
        let isValid = true;

        requiredInputs.forEach(input => {
            if (input.value.trim() === '') {
                isValid = false;
                return false; // Esci dal loop forEach
            }
        });

        return isValid;
    }
});
