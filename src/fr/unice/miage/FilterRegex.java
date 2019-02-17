package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterRegex implements FilenameFilter{
    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir.getPath()+ "/" +name);

        if (file.isDirectory()){
            return true;
        }

        Pattern pattern = Pattern.compile(".*/src.*");
        Matcher matcher = pattern.matcher(dir.getAbsolutePath());

        return matcher.matches();
    }
}