package fr.unice.miage.tp2;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse{

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException{
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse(nomClasse);
        afficheEnTeteClasse(cl);

        System.out.println("------------Attributs-----------");
        afficheAttributs(cl);

        System.out.println("------------Constructeurs-----------");
        afficheConstructeurs(cl);

        System.out.println("------------Méthodes-----------");
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException{
       Class c = Class.forName(nomClasse);
       return c;
    }


    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public static void afficheEnTeteClasse(Class cl) {
        String chaine = "";
        //  Affichage du modifier et du nom de la classe
        int mod = cl.getModifiers();
        String modifier = Modifier.toString(mod);
        String name = cl.getName();
        chaine+="Modifier de la classe: "+modifier+ "Nom de la classe: "+name;


        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        if (cl.getSuperclass() !=null && !(cl.getSuperclass() instanceof Object)){
            Class supercl = cl.getSuperclass();
            chaine += "extends "+supercl;
        }


        // Affichage des interfaces que la classe implemente
        if(cl.getInterfaces() != null){
            Object[] interfaces = cl.getInterfaces();
            chaine += " implements ";
            for(int i=0; i<interfaces.length;i++){
                Object inter = interfaces[i];
                if(i==0){
                    chaine += inter;
                }else{
                    chaine += ", " +inter;
                }
            }
        }
        System.out.println(chaine);

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    /**
     * Affiche les champs de la classe et des classes hérités
     * @param cl
     */
    public static void afficheAttributs(Class cl) {
        Field[] field = cl.getFields();
        for (int i=0; i<field.length; i++){
            Field f = field[i];
            System.out.println(f);
        }
    }

    /**
     * Affiche les constructeurs de la classe et des classes hérités
     * @param cl
     */
    public static void afficheConstructeurs(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for (int i=0; i<constructors.length; i++){
            Constructor constructor = constructors[i];
            System.out.println(constructor);
        }
        System.out.println("{}");
    }

    /**
     * Affiche les méthode de la classe et des classes hérités
     * @param cl
     */
    public static void afficheMethodes(Class cl) {
        Method[] method = cl.getMethods();
        for (int i=0; i<method.length; i++){
            Method metho = method[i];
            System.out.println(metho);
        }
        System.out.println("{}");
    }


    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();
                analyseClasse(nomClasse);
                ok = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            } catch (IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}
