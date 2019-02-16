package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

public class ListerRepertoire {
    public File reportoire;

    public ListerRepertoire() {
        this.reportoire = new File(".");
    }

    public File getReportoire() {
        return reportoire;
    }

    /**
     *Affiche les répertoire
     */
    public void listeRep(){
        String liste[] =  this.reportoire.list();
        if(liste !=null){
            for(int i=0; i<liste.length; i++){
                System.out.println(liste[i]);
            }
        }else{
            System.err.println("le repertoire n'est pas valide!");
        }
    }

    /**
     * Affiche les répertoires et le contenu
     * @param chemin
     */
    public void listerFichier(File chemin){
            for(File fichier:chemin.listFiles()){
                if(fichier.isDirectory()){
                    listerFichier(fichier);
                    System.out.println(fichier);
                }else{
                    System.out.println(fichier);
                }
            }
    }

    /**
     * Affiche les fichiers filtrés
     * @param chemin
     * @param filter
     */
    public void trouverFichier(File chemin, FilenameFilter filter){
        for(File fichier:chemin.listFiles(filter)){
            if(fichier.isDirectory()) {
                trouverFichier(fichier, filter);
            }else {
                System.out.println(fichier);
            }
        }
    }

    public static void main(String args[]) {
        ListerRepertoire liste = new ListerRepertoire();

        liste.listeRep();
        System.out.println("\n----------FIN QUESTION 1------------\n");

        liste.listerFichier(liste.getReportoire());
        System.out.println("\n----------FIN QUESTION 2------------\n");

        liste.trouverFichier(liste.getReportoire(),new MyFilenameFilter(".java"));
        System.out.println("\n----------FIN QUESTION 3------------\n");
    }
}
