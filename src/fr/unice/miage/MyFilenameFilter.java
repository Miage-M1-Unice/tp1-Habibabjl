package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

//Classe externe indépendante

public class MyFilenameFilter implements FilenameFilter {

    public String filtre;

    public MyFilenameFilter(String filtre) {
        this.filtre = filtre;
    }

    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir.getPath()+ "/" +name);
        return name.toLowerCase().endsWith(filtre) || file.isDirectory();
    }
}
