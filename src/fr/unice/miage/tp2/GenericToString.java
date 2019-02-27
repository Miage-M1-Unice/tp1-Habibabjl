package fr.unice.miage.tp2;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericToString {

    /**
     * affiche la valeur de chacun des champs de l'objet et la profondeur à laquelle on souhaite descendre
     * @param object
     * @param depth
     * @return
     * @throws IllegalAccessException
     */
    public String toString(Object object, int depth) throws IllegalAccessException{
        Class classe= object.getClass();
        String string = classe.getName() + "[";
        ArrayList<Field> fields = getAllFields(classe);

        for (int i=0; i<fields.size(); i++){
            if (depth <=0) return "";
            fields.get(i).setAccessible(true);
            string +=fields.get(i).getName() +"=";

            //les champs primitives
            if(fields.get(i).getType().isPrimitive()){
                string += fields.get(i).get(object);//value
                //fin de champ
                string += "; ";
             //les tableaux
            }else if(fields.get(i).getType().isArray()){

                string += fields.get(i).getName();
                string += "={";
                for (int j = 0; j < Array.getLength(fields.get(i).get(object)); j++) {
                    string += Array.get(fields.get(i).get(object), j);
                    if(j != Array.getLength(fields.get(i).get(object))-1)
                        string += ",";
                }
                string += "}; ";
            }else{
                string += toString(fields.get(i).get(object), depth-1)+"\n";
            }

        }
        return string+"]";
    }

    /**
     * Methode qui fournit tous les champs
     * @param classe
     * @return
     */
    private ArrayList<Field> getAllFields(Class classe) {
        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(classe.getFields()));

        for (Field field : classe.getDeclaredFields()) {
            if(!fields.contains(field))
                fields.add(field);
        }
        return fields;
    }

    public static void main(String[] args) {
        try {
            //System.out.println(new GenericToString().toString(new Point(12,24)));
            Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
            pol.getBounds();
            System.out.println(new GenericToString().toString(pol, 2));
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
