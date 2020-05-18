package main;

import services.Audit;
import services.BasePersistence;
import repository.*;
import services.FilePersistence;

import java.io.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        for (Object directory : dirs) {
            classes.addAll(findClasses((File) directory, packageName));
        }
        return (Class[]) classes.toArray(new Class[classes.size()]);
    }

    public static boolean isSetter(Method method) {
        return Modifier.isPublic(method.getModifiers()) &&
                method.getReturnType().equals(void.class) &&
                method.getParameterTypes().length == 1 &&
                method.getName().matches("^set[A-Z].*");
    }

    public static boolean isGetter(Method method) {
        if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0)
            return method.getName().matches("^get[A-Z].*") && !method.getReturnType().equals(void.class);
        return false;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, ParseException {
        System.out.println("Welcome! Continue? [y/n]");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("n")) System.exit(0);
        else {
            Class[] repositoryClasses = getClasses("repository");
            Integer crtIndexVal = 0;
            List<Class> usableClasses = new ArrayList<>();
            for (Class repositoryClass : repositoryClasses) {
                if (!Modifier.isAbstract(repositoryClass.getModifiers()) && !Modifier.isInterface(repositoryClass.getModifiers()) && Modifier.isPublic(repositoryClass.getModifiers())) {
                    usableClasses.add(repositoryClass);
                }
            }
            Class[] usableClassesAsArray = usableClasses.toArray(new Class[usableClasses.size()]);
            for (Integer i = 0; i < usableClassesAsArray.length; i++) {
                String crtClassName = usableClassesAsArray[i].getName();
                crtIndexVal = i + 1;
                System.out.println(crtIndexVal.toString() + ". " + crtClassName.substring(crtClassName.lastIndexOf(".") + 1));
            }
            int classNum = scanner.nextInt();
            HashSet<Employee> employees = null;
            List<Object> objectList = null;
            if (classNum >= 1 && classNum <= crtIndexVal) {
                Method[] callableMethods = usableClassesAsArray[classNum - 1].getMethods();
                List<Method> setterMethods = new ArrayList<>();
                for (Method callableMethod : callableMethods) {
                    if (isSetter(callableMethod)) {
                        setterMethods.add(callableMethod);
                    }
                }
                Method[] setterMethodsAsArray = setterMethods.toArray(new Method[setterMethods.size()]);
                int entries = scanner.nextInt();
                objectList = new ArrayList<>();
                for (int i = 0; i <= entries; i++) {
                    objectList.add(usableClassesAsArray[classNum - 1].getConstructor().newInstance());
                    System.out.println(objectList.get(i).getClass());
                    for (Method method : setterMethodsAsArray) {
                        System.out.println("Reading field " + method.getName().substring(3).toLowerCase() + " with type " + method.getParameters()[0].getType() + ":");
                        if (method.getParameters()[0].getType().toString().equals("class java.util.Date")) {
                            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
                            Date crtObject = format.parse(scanner.next());
                            System.out.println(crtObject.getClass());
                            method.invoke(objectList.get(i), crtObject);
                        } else {
                            Object temp = scanner.next();
                            Object crtObject = method.getParameters()[0].getType().getConstructor(temp.getClass()).newInstance(temp);
                            System.out.println(crtObject.getClass());
                            method.invoke(objectList.get(i), crtObject);
                        }
                    }
                    System.out.println(objectList.get(i).toString());
                }
            }
            BasePersistence bp = new BasePersistence();
            String sampleTableName = "Employees";
            employees = new HashSet(objectList);
            employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
            bp.addTable(sampleTableName, employees);
            System.out.println(bp.toString());
            FilePersistence<BasePersistence> fp = new FilePersistence<>();
            fp.setDb(bp);
            fp.writeToFile("fp_save.csv");
            fp.readFromFile("fp_save.csv");
            Audit audit = new Audit();
            audit.setDb(fp);
            audit.logPersistenceMethods("audit_save.csv");
        }
    }
}
