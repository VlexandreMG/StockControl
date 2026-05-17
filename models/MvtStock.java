package models;

import java.util.Date;

public class MvtStock {
    private Date date;
    private int quantite;
    private double prixUnitaire;
    private double valeur;
    private int stock;
    private double valeurStock;
    private double cump;
    private int source;

    public MvtStock() {}

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public double getValeur() {
        return valeur;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getValeurStock() {
        return valeurStock;
    }
    public void setValeurStock(double valeurStock) {
        this.valeurStock = valeurStock;
    }
    public double getCump() {
        return cump;
    }
    public void setCump(double cump) {
        this.cump = cump;
    }
    public int getSource() {
        return source;
    }
    public void setSource(int source) {
        this.source = source;
    }
}
