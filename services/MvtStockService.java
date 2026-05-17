package services;

import java.util.Date;
import models.Article;
import models.MvtStock;

import java.util.List;;

public class MvtStockService {

    public MvtStockService() {}

        //Fonction tsisy asany
    public int getSource() {
        return 0;
    }
        //Fonction tsisy asany
    public int calculerCUMP(Article article) {
        return 0;
    }

    public double calculerValeurStock(Article article , List<Double> valeurStock) {
        if (valeurStock.isEmpty()) {
            return article.getQuantite() * article.getPrix();
        } else {
            //Get the last element of the list
            double lastValeurStock = valeurStock.get(valeurStock.size() - 1);
            return lastValeurStock + (article.getQuantite() * article.getPrix());
        }
    }
    
    public int calculerStock(Article article , List<Integer> stock) {
        if (stock.isEmpty()) {
            return article.getQuantite();
        } else {
            //Get the last element of the list
            int lastStock = stock.get(stock.size() - 1);
            return lastStock + article.getQuantite();
        }
    }

    public double calculerValeur(Article article) {
        return article.getQuantite() * article.getPrix();
    }

    public MvtStock creerEntree(Date date,Article article, List<Double> valeurStock, List<Integer> stock, String type) {
            //Bloc des fonctions 
        double valeur = calculerValeur(article);
        int quantite = calculerStock(article, stock);
        double valeurStocke = calculerValeurStock(article, valeurStock);
        double cump = calculerCUMP(article);
        int source = getSource();
            //Bloc création de l'objet MvtStock
        MvtStock mvtStock = new MvtStock();
        mvtStock.setArticle(article);
        mvtStock.setValeur(valeur);
        mvtStock.setStock(quantite);
        mvtStock.setValeurStock(valeurStocke);
        mvtStock.setCump(cump);
        mvtStock.setSource(source);
        mvtStock.setDate(date);
        mvtStock.setType(type);
        return mvtStock;
    }
}
