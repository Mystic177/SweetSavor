package model;

public class Prodotto {
    private String nomeProdotto;
    private String descrizione;//max chars
    private double prezzo;
    private int disponibility; //e quantità disponibile
    private boolean disponibile;
    private String categoria;
    private byte[] img;

    public Prodotto(String nomeProdotto, String descrizione, double prezzo, int disponibility, boolean disponibile, String categoria, byte[] img) {
        this.nomeProdotto = nomeProdotto;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.disponibility = disponibility;
        this.disponibile = disponibile;
        this.categoria = categoria;
        this.img = img;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
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
    

    public void setDisponibility(int disponibility) {
        if(disponibility == 0) {
            this.disponibile = false;
        }
        this.disponibility = disponibility;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getDisponibility() {
        return disponibility;
    }
}