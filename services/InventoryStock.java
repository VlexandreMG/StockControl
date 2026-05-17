package services;

import models.Article;

public class InventoryStock {
    
    public InventoryStock() {};

    public String EntreeOuSortie(Article article, String type) {
        if (type.equals("ENTREE")) {
            return "Entrée de " + article.getQuantite() + " " + article.getNom() + " au prix de " + article.getPrix() + "€";
        } else if (type.equals("SORTIE")) {
            return "Sortie de " + article.getQuantite() + " " + article.getNom() + " au prix de " + article.getPrix() + "€";
        } else {
            return "Type d'opération inconnu.";
        }
    }
}
