package com.skyline.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SkylineUtils {

    private static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private static void getAllInterfaces(Class<?> clazz, List<Class<? extends Class<?>>> interfacesFound) {
        if (clazz != null) {
            Set<Class> interfaces = findAllClassesUsingClassLoader("com.skyline.jobs");
            Iterator<Class> interfacesIterator = interfaces.iterator();
            while (interfacesIterator.hasNext()) {
                Class findClass =  interfacesIterator.next();
                if (!findClass.isInterface()) {
                    interfacesFound.add(findClass);
                }
            }
        }
    }

    public static List<Class<? extends Class<?>>> getAllInterfaces(Class<?> clazz) {
        if (clazz == null) {
            System.out.println(">>>>>>>>>> Log : null argument ");
            return new ArrayList<>();
        }
        List<Class<? extends Class<?>>> interfacesFound = new ArrayList<>();
        getAllInterfaces(clazz, interfacesFound);
        return interfacesFound;
    }
}
