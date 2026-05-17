import services.InventoryStock;
import models.Article;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le système de contrôle de stock !");

        // Entrée na sortie 
        Article article = new Article();   
        article.setNom("Test");
        article.setQuantite(10);
        article.setPrix(5.0);

        InventoryStock inventory = new InventoryStock();
        System.out.println(inventory.EntreeOuSortie(article, "ENTREE"));
    }
}
