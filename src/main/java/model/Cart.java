package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Prodotto> listaProdotti;
    private int totaleCarrello;

    public Cart() {
        listaProdotti = new ArrayList<>();
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void addProdotto(Prodotto prodotto) {
        // Verifica se il prodotto è già presente nel carrello
        for (Prodotto p : listaProdotti) {
            if (p.equals(prodotto)) {
                // Se il prodotto è già presente, incrementa la quantità e aggiorna il totale
                p.setDisponibility(p.getDisponibility() + 1);
                return; // Esci dal metodo una volta incrementata la quantità
            }
        }

        // Se il prodotto non è presente nel carrello, aggiungilo
        listaProdotti.add(prodotto);
    }

    public void removeProdotto(Prodotto prodotto) {
        listaProdotti.remove(prodotto);
    }

    public double getTotalPrize() {
        double total = 0;
        for (Prodotto prodotto : listaProdotti) {
            total += prodotto.getPrezzo() * prodotto.getDisponibility();
        }
        return total;
    }

    public boolean isEmpty() {
        return listaProdotti.isEmpty();
    }
}
