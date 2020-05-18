package services;

import java.io.*;

public class FilePersistence<T extends BasePersistence> {
    private final static class SingletonHolder {
        private static final FilePersistence INSTANCE = new FilePersistence();
    }

    public static FilePersistence getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private T db;
    public T getDb() {
        return db;
    }

    public void setDb(T db) { this.db = db; }

    public void writeToFile(String file_path) throws IOException {
        FileWriter csvWriter =  new FileWriter(file_path, true);
        csvWriter.append(getDb().toString());
        csvWriter.append('\n');
        csvWriter.flush();
        csvWriter.close();
    }

    public void readFromFile(String file_path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(file_path));
        String fileRow;
        while ((fileRow = csvReader.readLine()) != null) {
            System.out.println(fileRow);
        }
    }
}
