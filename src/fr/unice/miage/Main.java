package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        System.out.println("\n----------Question 1.a)-----------\n");
        ListerRepertoire liste = new ListerRepertoire();

        liste.listeRep();
        System.out.println("\n----------FIN QUESTION 1------------\n");

        liste.listerFichier(liste.getReportoire());
        System.out.println("\n----------FIN QUESTION 2------------\n");

        //Classe externe
        System.out.println("---Classe externe---");
        liste.trouverFichier(liste.getReportoire(),new MyFilenameFilter(".java"));

        //Classe interne nommée
        System.out.println("---Classe interne nommée---");
        liste.trouverFichier(liste.getReportoire(),new MyFilenameFilter(".java"));

        //Classe interne anonyme
        System.out.println("---Classe interne anonyme---");
        liste.trouverFichier(new File("."),new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir.getAbsolutePath() + "/" + name);
                if (file.isDirectory()) {
                    return true;
                }
                return name.toLowerCase().endsWith(".java");
            }
        });
        System.out.println("\n----------FIN QUESTION 3------------\n");

        QuestionB b = new QuestionB();
        try{
            b.find();
            b.findFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("\n----------FIN QUESTION 1.b)------------\n");
    }
}
