package services;

import java.util.ArrayList;
import java.util.Date;
import models.Article;
import models.MvtStock;
import java.util.List;;

public class MvtStockService {

    public MvtStockService() {
    }

    // Fonction tsisy asany
    public int getSource() {
        return 0;
    }

    // Fonction tsisy asany
    public int calculerCUMP(Article article) {
        return 0;
    }

    public double calculerValeurStock(Article article, List<MvtStock> historiqueMvt) {
        if (historiqueMvt.isEmpty()) {
            return article.getQuantite() * article.getPrix();
        } else {
            // Get the last element of the list
            double lastValeurStock = historiqueMvt.get(historiqueMvt.size() - 1).getValeurStock();
            return lastValeurStock + (article.getQuantite() * article.getPrix());
        }
    }

    public int calculerStock(Article article, List<MvtStock> historiqueMvt) {
        if (historiqueMvt.isEmpty()) {
            return article.getQuantite();
        } else {
            // Get the last element of the list
            int lastStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
            return lastStock + article.getQuantite();
        }
    }

    public double calculerValeur(Article article) {
        return article.getQuantite() * article.getPrix();
    }

    public MvtStock creerEntree(Date date, Article article, List<MvtStock> historiqueMvt, String type) {
        // Bloc des fonctions
        double valeur = calculerValeur(article);
        int quantite = calculerStock(article, historiqueMvt);
        double valeurStocke = calculerValeurStock(article, historiqueMvt);
        double cump = calculerCUMP(article);
        int source = getSource();
        // Bloc création de l'objet MvtStock
        MvtStock mvtStock = new MvtStock();
        mvtStock.setNomArticle(article.getNom());
        mvtStock.setQuantite(article.getQuantite());
        mvtStock.setPrixUnitaire(article.getPrix());
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

    // public List<MvtStock> sortieFifo(List<MvtStock> historiqueMvt, Article
    // article , Date date ) {
    // //Liste de sortie generee
    // List<MvtStock> sortieGeneree = new ArrayList<>();
    // int sortie = article.getQuantite();
    // //Mitety ligne
    // for (MvtStock mvt : historiqueMvt) {
    // int articleQuantite = article.getQuantite();
    // if (articleQuantite == sortie) {
    // // Calcul du valeur stock
    // double valeurStockAvant = historiqueMvt.get(historiqueMvt.size() -
    // 1).getValeurStock();
    // double valeurStockApres = valeurStockAvant - sortie * article.getPrix();
    // // Calcul du stock après la sortie
    // int dernierStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
    // int stockSortie = dernierStock - sortie;
    // // Création du mouvement de sortie
    // MvtStock mvtStock = new MvtStock();
    // mvtStock.setQuantite(article.getQuantite());
    // mvtStock.setPrixUnitaire(article.getPrix());
    // mvtStock.setValeur(sortie * article.getPrix());
    // mvtStock.setStock(stockSortie);
    // mvtStock.setValeurStock(valeurStockApres);
    // mvtStock.setDate(date);
    // mvtStock.setType("SORTIE");
    // mvtStock.setSource(mvt.getId());

    // //Changement sur l'article
    // article.setPrix(article.getPrix());
    // //Ajout dans la liste
    // sortieGeneree.add(mvtStock);
    // return sortieGeneree;
    // } else if (articleQuantite > sortie) {
    // // Calcul du stock après la sortie
    // int dernierStock = historiqueMvt.get(historiqueMvt.size() - 1).getStock();
    // int stockSortie = dernierStock - sortie;
    // // Calcul du valeur stock
    // double valeurStockAvant = historiqueMvt.get(historiqueMvt.size() -
    // 1).getValeurStock();
    // double valeurStockApres = valeurStockAvant - sortie * article.getPrix();
    // // Création du mouvement de sortie
    // MvtStock mvtStock = new MvtStock();
    // mvtStock.setQuantite(articleQuantite);
    // mvtStock.setPrixUnitaire(article.getPrix());
    // mvtStock.setValeur(sortie * article.getPrix());
    // mvtStock.setStock(stockSortie);
    // mvtStock.setValeurStock(valeurStockApres);
    // mvtStock.setDate(date);
    // mvtStock.setType("SORTIE");
    // mvtStock.setSource(mvt.getId());
    // //Changement sur l'article
    // article.setQuantite(sortie);
    // article.setPrix(article.getPrix());
    // //Ajout dans la liste
    // sortieGeneree.add(mvtStock);
    // return sortieGeneree;
    // } else if (articleQuantite < sortie) {
    // // Calcul anle soustraction
    // sortie = sortie - articleQuantite;
    // //Création du mvtStock
    // MvtStock mvtStock = new MvtStock();
    // mvtStock.setQuantite(sortie);
    // mvtStock.setPrixUnitaire(article.getPrix());
    // mvtStock.setValeur(article.getQuantite() * article.getPrix());
    // mvtStock.setStock(sortie - article.getQuantite());
    // mvtStock.setValeurStock(sortie);
    // mvtStock.setDate(date);
    // mvtStock.setType("SORTIE");
    // mvtStock.setSource(mvt.getId());
    // //Ajout dans la liste des sorties
    // sortieGeneree.add(mvtStock);

    // }
    // }
    // return null;
    // }

    public int calculQuantiteDispoSurLot(MvtStock mvtStock, List<MvtStock> historiQueMvt) {
        int reste = mvtStock.getQuantite();

        for (MvtStock mvtStock2 : historiQueMvt) {

            if (mvtStock2.getType() == "SORTIE" && mvtStock2.getSource() == mvtStock.getId()) {
                reste = reste - mvtStock2.getQuantite();
            }
        }
        return reste;
    }

    public List<MvtStock> sortieFifo(Article article, List<MvtStock> historiQueMvt, Date date) {
        // Article
        int reste = article.getQuantite();
        String nomArticle = article.getNom();

        // SortieGeneree
        List<MvtStock> sortieGeneree = new ArrayList<>();

        // Boucle sur l'historique des mvt
        // Remplacer le for (MvtStock mvtStock : historiQueMvt) par un for classique :
        for (int i = 0; i < historiQueMvt.size(); i++) {
            // On récupère l'élément à l'indice i
            MvtStock mvtStock = historiQueMvt.get(i);

            if (!mvtStock.getType().equals("ENTREE") || !mvtStock.getNomArticle().equals(nomArticle)) {
                continue;
            }

            int dispoLot = calculQuantiteDispoSurLot(mvtStock, historiQueMvt);
            if (dispoLot <= 0) {
                continue;
            }

            int dernierStock = historiQueMvt.get(historiQueMvt.size() - 1).getStock();
            double derniereValeurStock = historiQueMvt.get(historiQueMvt.size() - 1).getValeurStock();

            if (dispoLot >= reste) {
                MvtStock mvt = new MvtStock();
                mvt.setNomArticle(nomArticle);
                mvt.setQuantite(reste);
                mvt.setPrixUnitaire(mvtStock.getPrixUnitaire());
                mvt.setValeur(reste * mvtStock.getPrixUnitaire());
                mvt.setStock(dernierStock - reste);
                mvt.setValeurStock(derniereValeurStock - (reste * mvtStock.getPrixUnitaire()));
                mvt.setDate(date);
                mvt.setType("SORTIE");
                mvt.setSource(mvtStock.getId());

                sortieGeneree.add(mvt);
                return sortieGeneree;
            } else {
                MvtStock mvt = new MvtStock();
                mvt.setNomArticle(nomArticle);
                mvt.setQuantite(dispoLot);
                mvt.setPrixUnitaire(mvtStock.getPrixUnitaire());
                mvt.setValeur(dispoLot * mvtStock.getPrixUnitaire());
                mvt.setStock(dernierStock - dispoLot);
                mvt.setValeurStock(derniereValeurStock - (dispoLot * mvtStock.getPrixUnitaire()));
                mvt.setDate(date);
                mvt.setType("SORTIE");
                mvt.setSource(mvtStock.getId());

                sortieGeneree.add(mvt);

                historiQueMvt.add(mvt); // <─── ICI : Ça ne plantera plus !
                reste = reste - dispoLot;
            }
        }
        return sortieGeneree;
    }
}
