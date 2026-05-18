import services.InventoryStock;
import models.Article;
import models.MvtStock;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le système de contrôle de stock !");

            // Entrée na sortie 
        Article article = new Article();   
        article.setNom("Test");
        article.setQuantite(10);
        article.setPrix(5.0);

        Article article2 = new Article();
        article2.setNom("Test2");
        article2.setQuantite(20);
        article2.setPrix(10.0);

        Article article3 = new Article();
        article3.setNom("Sortie");
        article3.setQuantite(20);
        article3.setPrix(15.0);

        Article article4 = new Article();
        article4.setNom("Test4");
        article4.setQuantite(3);
        article4.setPrix(20.0);

            // Date du jour uniquement (sans heure)
        Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
        
            //Liste de tous les mouvements
        List<MvtStock> historiqueMvt = new ArrayList<>();

        InventoryStock inventory = new InventoryStock();
        inventory.EntreeOuSortie(article2, historiqueMvt, date, "ENTREE");
        inventory.EntreeOuSortie(article, historiqueMvt, date, "ENTREE");
        inventory.EntreeOuSortie(article3, historiqueMvt, date, "SORTIE");
        inventory.EntreeOuSortie(article4, historiqueMvt, date, "SORTIE");

            // Taille d'historiqueMvt après l'entrée
        System.out.println("Taille de l'historique des mouvements après entrée : " + historiqueMvt.size());
    }
}
