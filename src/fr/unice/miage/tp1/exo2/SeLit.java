package fr.unice.miage.tp1.exo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SeLit {

    /**
     * Méthode qui permet de lire un fichier
     * @param source
     */
    void lecture(Scanner source){
            while(source.hasNextLine()){
                String s = source.nextLine();
                if(!s.trim().startsWith("//")) {
                    System.out.println("LU:" + s);
                }
            }
    }

    /**
     * Methode qui permet d'écrire dans un fichier
     * @param nomFichier
     * @throws IOException
     */
    void ecriture(String nomFichier) throws IOException{
        PrintStream printStream = System.out;
        File file = new File("./"+nomFichier);
        file.createNewFile();

        Scanner scanner= new Scanner(System.in);
        System.setOut(new PrintStream(file));
        System.out.println(scanner.nextLine());

        System.setOut(printStream);
    }

    public static void main(String args[]) {
        SeLit seLit = new SeLit();
        File file = new File("./src/fr/unice/miage/tp1/exo2/Selit.java");
        //Question 1
        try{
            Scanner scanner = new Scanner(file);
            seLit.lecture(scanner);
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Question 2
        try{
            seLit.ecriture("outpout.txt");
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
