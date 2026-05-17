import services.InventoryStock;
import models.Article;
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

            // Date du jour uniquement (sans heure)
        Date date = java.sql.Date.valueOf(java.time.LocalDate.now());

            //List stock 
        List<Double> valeurStock = new ArrayList<>();
        List<Integer> stock = new ArrayList<>();
        
        InventoryStock inventory = new InventoryStock();
        inventory.EntreeOuSortie(article, valeurStock, stock, date, "ENTREE");
    }
}
