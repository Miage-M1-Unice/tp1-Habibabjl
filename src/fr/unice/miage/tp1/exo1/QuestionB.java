package fr.unice.miage.tp1.exo1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class QuestionB {

    public void find()throws IOException{
        Files.walkFileTree(new File(".").toPath(), new ListFiles());
    }

    public void findFile() throws IOException{
        Files.walkFileTree(new File(".").toPath(), new FilterFiles(".java"));
    }
    public class ListFiles extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            System.out.println(file);
            return super.visitFile(file,attrs);
        }

    }

    public class FilterFiles extends SimpleFileVisitor<Path> {
        public String filter;

        public FilterFiles(String filter) {
            this.filter = filter;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            if (file.toString().endsWith(filter)){
                System.out.println(file);
            }
            return super.visitFile(file,attrs);
        }
    }
}
