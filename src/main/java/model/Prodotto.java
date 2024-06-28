package model;

public class Prodotto {
    private String nomeProdotto;
    private String descrizione;//max chars
    private double prezzo;
    private int disponibilità; //e quantità disponibile
    private boolean disponibile;
    private String categoria;
    private byte[] img;

    public Prodotto(String nomeProdotto, String descrizione, double prezzo, int disponibilità, boolean disponibile, String categoria, byte[] img) {
        this.nomeProdotto = nomeProdotto;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.disponibilità = disponibilità;
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

    public int getDisponibility() {
        return disponibilità;
    }

    public void setDisponibilità(int disponibilità) {
        if(disponibilità == 0) {
            this.disponibile = false;
        }
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getDisponibilità() {
        return disponibilità;
    }
}