package model;

public class Prodotto {
    
    private String descrizione;//max chars
    private double prezzo;
    private int disponibilità; //e quantità disponibile
    private boolean disponibile;
    private String categoria;
    private String imgUrl;

    public Prodotto(String descrizione, double prezzo, int disponibilità, boolean disponibile, String venditore, String categoria, String imgUrl) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.disponibilità = disponibilità;
        this.disponibile = disponibile;
        this.categoria = categoria;
        this.imgUrl = imgUrl;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibilità() {
        return disponibilità;
    }

    public void setDisponibilità(int disponibilità) {
        this.disponibilità = disponibilità;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

   
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}