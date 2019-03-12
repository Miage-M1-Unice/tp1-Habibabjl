package fr.unice.miage.tp3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String args[]) throws MalformedURLException {
        // Getting the jar URL which contains target class
        URL[] classLoaderUrls = new URL[]{new URL("file:///Users/I353574/OneDrive - SAP SE/habiba/MIAGE/M1 MIAGE/S2/Programmation objet/tp3/out/production/tp3/")};

        // Create a new URLClassLoader
       try(URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls)){
           // Load the target class
           Class testClass = urlClassLoader.loadClass("miage.m1.Test");

           // Create a new instance from the loaded class
           Constructor<?> constructor = testClass.getConstructor();
           Object testObj = constructor.newInstance();

           // Getting a method from the loaded class and invoke it
           Method method = testClass.getMethod("sayHello");
           method.invoke(testObj);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
