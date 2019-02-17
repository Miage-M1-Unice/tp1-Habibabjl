package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

public class ListerRepertoire {
    private File reportoire;

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
     * @param filtre
     */
    public void trouverFichier(File chemin, FilenameFilter filtre){
      //  MyFilenameFilterInternal f = new MyFilenameFilterInternal(filtre);

        for(File fichier:chemin.listFiles(filtre)){
            if(fichier.isDirectory()) {
                trouverFichier(fichier, filtre);
            }else {
                System.out.println(fichier);
            }
        }
    }

    /**
     * Classe interne nommée
     */
    public class MyFilenameFilterInternal implements FilenameFilter {
        public String filtre;

        public MyFilenameFilterInternal(String filtre) {
            this.filtre = filtre;
        }

        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir.getPath()+ "/" +name);
            return name.toLowerCase().endsWith(filtre) || file.isDirectory();
        }
    }
}
