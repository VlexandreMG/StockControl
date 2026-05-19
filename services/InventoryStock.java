package services;

import models.Article;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import models.MvtStock;

public class InventoryStock {

    public InventoryStock() {
    };

    public List<MvtStock> EntreeOuSortie(Article article, List<MvtStock> historiqueMvt, Date date, String type) {
        // Création de l'objet MvtStockService
        MvtStockService mvtStockService = new MvtStockService();
        List<MvtStock> ListmvtStock = new ArrayList<>();

        if (type.equals("ENTREE")) {
            // Appel de creerEntree
            MvtStock mvtStock = mvtStockService.creerEntree(date, article, historiqueMvt, type);
            // Ajout à la liste mvt stock
            ListmvtStock.add(mvtStock);
            // Ajout à l'historique mouvement de Stock
            historiqueMvt.add(mvtStock);

            System.out.println("===============================\n");
            System.out.println(
                    "Date d'entrée : " + mvtStock.getDate() + "\n" +
                            "Nom de l'article : " + mvtStock.getNomArticle() + "\n" +
                            "Quantité entrée : " + mvtStock.getQuantite() + "\n" +
                            "Prix untaire de l'entrée : " + mvtStock.getPrixUnitaire() + "\n" +
                            "Valeur de l'entrée : " + mvtStock.getValeur() + "\n" +
                            "Stock : " + mvtStock.getStock() + "\n" +
                            "Valeur du stock : " + mvtStock.getValeurStock() + "\n" +
                            "CUMP : " + mvtStock.getCump() + "\n" +
                            "Type de mouvement : " + mvtStock.getType() + "\n" +
                            "Source : " + mvtStock.getSource() + "\n");
            System.out.println("===============================\n");

            return ListmvtStock;
        } else if (type.equals("SORTIE")) {
            List<MvtStock> ListSortieStock = mvtStockService.sortieFifo(article, historiqueMvt, date);
            // Ajout à la liste de mvt stock
            ListmvtStock.addAll(ListSortieStock);
            // Ajout au mouvement de Stock
            historiqueMvt.addAll(ListSortieStock);
            // Affichage de la sortie
            for (MvtStock mvtStock : ListSortieStock) {
                System.out.println("===============================\n");
                System.out.println(
                        "Date de sortie : " + mvtStock.getDate() + "\n" +
                                "Nom de l'article : " + mvtStock.getNomArticle() + "\n" +
                                "Quantité sortie : " + mvtStock.getQuantite() + "\n" +
                                "Prix untaire de la sortie : " + mvtStock.getPrixUnitaire() + "\n" +
                                "Valeur de la sortie : " + mvtStock.getValeur() + "\n" +
                                "Stock : " + mvtStock.getStock() + "\n" +
                                "Valeur du stock : " + mvtStock.getValeurStock() + "\n" +
                                "CUMP : " + mvtStock.getCump() + "\n" +
                                "Type de mouvement : " + mvtStock.getType() + "\n" +
                                "Source : " + mvtStock.getSource() + "\n");
                System.out.println("===============================\n");
            }

            return ListmvtStock;
        } else {
            return null;
        }
    }
}
