package fr.unice.miage;

import java.io.File;
import java.io.IOException;

public class ListerRepertoire {
    public File reportoire;

    public ListerRepertoire() {
        this.reportoire = new File(".");
    }

    public File getReportoire() {
        return reportoire;
    }

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
    
    public static void main(String args[]) {
        ListerRepertoire liste = new ListerRepertoire();
       // liste.listeRep();
        liste.listerFichier(liste.getReportoire());
    }
}
