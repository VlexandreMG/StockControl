package services;

import models.Article;
import java.util.List;
import java.util.Date;
import models.MvtStock;

public class InventoryStock {

    public InventoryStock() {};

    public MvtStock EntreeOuSortie(Article article, List<MvtStock> historiqueMvt, Date date ,String type) {
        if (type.equals("ENTREE")) {
                //Appel de creerEntree
            MvtStockService mvtStockService = new MvtStockService();
            MvtStock mvtStock = mvtStockService.creerEntree(date,article,historiqueMvt,type);
                //Ajout au mouvement de Stock 
            historiqueMvt.add(mvtStock);

            System.out.println("===============================\n");
            System.out.println(
            "Date d'entrée : " + mvtStock.getDate() + "\n"+
            "Quantité entrée : " + article.getQuantite() + "\n"+
            "Prix untaire de l'entrée : " + article.getPrix() + "\n"+
            "Valeur de l'entrée : " + mvtStock.getValeur() + "\n"+
            "Stock : " + mvtStock.getStock() + "\n"+ 
            "Valeur du stock : " + mvtStock.getValeurStock() + "\n"+
            "CUMP : " + mvtStock.getCump() + "\n"+
            "Type de mouvement : " + mvtStock.getType() + "\n"+
            "Source : " + mvtStock.getSource() + "\n");
            System.out.println("===============================\n");

            return mvtStock;
        } else if (type.equals("SORTIE")) {
            MvtStockService mvtStockService = new MvtStockService();
            MvtStock mvtStock = mvtStockService.sortieFifo(historiqueMvt, article, date);
                //Ajout au mouvement de Stock
            historiqueMvt.add(mvtStock);
                //Affichage de la sortie
            System.out.println("===============================\n");
            System.out.println(
            "Date de sortie : " + mvtStock.getDate() + "\n"+
            "Quantité sortie : " + article.getQuantite() + "\n"+
            "Prix untaire de la sortie : " + article.getPrix() + "\n"+
            "Valeur de la sortie : " + mvtStock.getValeur() + "\n"+
            "Stock : " + mvtStock.getStock() + "\n"+ 
            "Valeur du stock : " + mvtStock.getValeurStock() + "\n"+
            "CUMP : " + mvtStock.getCump() + "\n"+
            "Type de mouvement : " + mvtStock.getType() + "\n"+
            "Source : " + mvtStock.getSource() + "\n");
            System.out.println("===============================\n");
            return mvtStock;
        } else {
            return null;
        }
    }
}
