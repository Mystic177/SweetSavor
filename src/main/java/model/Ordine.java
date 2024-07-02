package model;

public class Ordine {
    private String orderID;
    private String dataOrdine;
    private String nomeCliente;
    private String cognomeCliente;
    private String cap;
    private String indirizzoDiConsegna;
    private double totale;
    private boolean stato;

    public Ordine(String orderID, String dataOrdine, String nomeCliente, String cognomeCliente, String cap, String indirizzoDiConsegna, double totale, boolean stato) {
        this.orderID = orderID;
        this.dataOrdine = dataOrdine;
        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
        this.cap = cap;
        this.indirizzoDiConsegna = indirizzoDiConsegna;
        this.totale = totale;
        this.stato = stato;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(String dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCognomeCliente() {
        return cognomeCliente;
    }

    public void setCognomeCliente(String cognomeCliente) {
        this.cognomeCliente = cognomeCliente;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getIndirizzoDiConsegna() {
        return indirizzoDiConsegna;
    }

    public void setIndirizzoDiConsegna(String indirizzoDiConsegna) {
        this.indirizzoDiConsegna = indirizzoDiConsegna;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }
}