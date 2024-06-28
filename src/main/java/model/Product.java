package model;


//classe java per il prodotto (creare pagina web per ogni prodotto)
//collegamento al Database
//Prefisso = 

import control.DatabaseProductInteraction;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String imageUrl;

    public Product(int productId, String productName, String productDescription, double productPrice, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void encryptString(String str){
//        Connessione al database
//        connettore al database
//        Scrittura nel database
//        https://github.com/MoonMr404/p    file utili
        DatabaseProductInteraction connection = new DatabaseProductInteraction();




    }





}