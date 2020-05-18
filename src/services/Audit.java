package services;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Audit {
    private final static class SingletonHolder {
        private static final Audit INSTANCE = new Audit();
    }
    public static Audit getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private FilePersistence<?> db;

    public FilePersistence<?> getDb() { return db; }

    public void setDb(FilePersistence<?> db) {
        this.db = db;
    }

    public void logPersistenceMethods(String file_path) throws IOException {
        StackTraceElement[]   elems = Thread.currentThread().getStackTrace();
        StackTraceElement     elem = null;
        if (elems.length > 1) elem = elems[1];
        FileWriter csvWriter =  new FileWriter(file_path, true);
        csvWriter.append(elem.getMethodName());
        csvWriter.append(", ");
        csvWriter.append(new Date().toString());
        csvWriter.append(", ");
        csvWriter.append(Thread.currentThread().getName());
        csvWriter.append('\n');
        csvWriter.flush();
        csvWriter.close();
    }

}
