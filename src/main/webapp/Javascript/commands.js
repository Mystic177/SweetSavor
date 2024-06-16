function buyProduct(){

}


document.addEventListener("DOMContentLoaded", function() {
    let slideIndex = 1;
    showSlides(slideIndex);

    // Controlli per avanti/indietro
    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    // Mostra la slide corrente
    function currentSlide(n) {
        showSlides(slideIndex = n);
        updateShowcase(n);
    }

    // Mostra le slide
    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        if (n > slides.length) {
            slideIndex = 1;
        }
        if (n < 1) {
            slideIndex = slides.length;
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slides[slideIndex - 1].style.display = "block";
    }

    // Aggiorna l'immagine nel showcase
    function updateShowcase(n) {
        let previews = document.querySelectorAll('.preview');
        previews.forEach((preview, index) => {
            if (index + 1 === n) {
                preview.classList.add('active');
            } else {
                preview.classList.remove('active');
            }
        });
    }

    // Event listeners per i bottoni
    document.querySelector('.left-button').addEventListener('click', function() {
        plusSlides(-1);
    });
    document.querySelector('.right-button').addEventListener('click', function() {
        plusSlides(1);
    });

    // Event listeners per le immagini di anteprima
    // const previews = document.querySelectorAll('.preview');
    // previews.forEach((preview, index) => {
    //     preview.addEventListener('click', function() {
    //         currentSlide(index + 1);
    //     });
    // });
});
