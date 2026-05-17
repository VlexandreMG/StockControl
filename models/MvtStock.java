package models;

import java.util.Date;

public class MvtStock {
    private Date date;
    private Article article;
    private double valeur;
    private int stock;
    private double valeurStock;
    private double cump;
    private int source;
    private String type;

    public MvtStock() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
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
