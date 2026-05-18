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

    public double calculerValeurStock(Article article , List<MvtStock> historiqueMvt) {
        if (historiqueMvt.isEmpty()) {
            return article.getQuantite() * article.getPrix();
        } else {
            //Get the last element of the list
            double lastValeurStock = historiqueMvt.get(historiqueMvt.size() - 1).getValeurStock();
            return lastValeurStock + (article.getQuantite() * article.getPrix());
        }
    }
    
    public int calculerStock(Article article , List<MvtStock> historiqueMvt) {
        if (historiqueMvt.isEmpty()) {
            return article.getQuantite();
        } else {
            //Get the last element of the list
            int lastStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
            return lastStock + article.getQuantite();
        }
    }

    public double calculerValeur(Article article) {
        return article.getQuantite() * article.getPrix();
    }

    public MvtStock creerEntree(Date date,Article article, List<MvtStock> historiqueMvt, String type) {
            //Bloc des fonctions 
        double valeur = calculerValeur(article);
        int quantite = calculerStock(article, historiqueMvt);
        double valeurStocke = calculerValeurStock(article, historiqueMvt);
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

    public MvtStock creerSortie() {
        return null;
    }

    public MvtStock sortieFifo(List<MvtStock> historiqueMvt, Article article , Date date ) {
            
        int sortie = article.getQuantite();
        //Mitety ligne 
        for (MvtStock mvt : historiqueMvt) {
            int articleQuantite = mvt.getArticle().getQuantite();
            if (articleQuantite == sortie) {
                    // Calcul du valeur stock 
                double valeurStockAvant = historiqueMvt.get(historiqueMvt.size() - 1).getValeurStock();
                double valeurStockApres = valeurStockAvant - sortie * mvt.getArticle().getPrix();
                    // Calcul du stock après la sortie
                int dernierStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
                int stockSortie = dernierStock - sortie;
                    // Création du mouvement de sortie
                MvtStock mvtStock = new MvtStock();
                mvtStock.setArticle(article);
                mvtStock.setValeur(sortie * mvt.getArticle().getPrix());
                mvtStock.setStock(stockSortie);
                mvtStock.setValeurStock(valeurStockApres);
                mvtStock.setDate(date);
                mvtStock.setType("SORTIE");
                mvtStock.setSource(mvt.getId());
                
                    //Changement sur l'article 
                article.setPrix(mvt.getArticle().getPrix());
                return mvtStock;
            } else if (articleQuantite > sortie) {
                    // Calcul du stock après la sortie
                int dernierStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
                int stockSortie = dernierStock - sortie;
                    // Calcul du valeur stock 
                double valeurStockAvant = historiqueMvt.get(historiqueMvt.size() - 1).getValeurStock();
                double valeurStockApres = valeurStockAvant - sortie * mvt.getArticle().getPrix();
                    // Création du mouvement de sortie
                MvtStock mvtStock = new MvtStock();
                mvtStock.setArticle(article);
                mvtStock.setValeur(sortie * mvt.getArticle().getPrix());
                mvtStock.setStock(stockSortie);
                mvtStock.setValeurStock(valeurStockApres);
                mvtStock.setDate(date);
                mvtStock.setType("SORTIE");
                mvtStock.setSource(mvt.getId());
                    //Changement sur l'article 
                article.setQuantite(sortie);
                article.setPrix(mvt.getArticle().getPrix());
                return mvtStock;
            } else if (articleQuantite < sortie) {
                    // Calcul anle soustraction 
                sortie = sortie - articleQuantite;
            }
        }
        return null;
    }
}
