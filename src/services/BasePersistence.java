package services;

import java.util.*;
import java.lang.*;

public class BasePersistence {
    private Hashtable<String, HashSet<?>> tables;

    public Hashtable<String, HashSet<?>> getTables() {
        return tables;
    }

    public Enumeration<String> getTable_names() {
        return tables.keys();
    }

    public boolean findTable(String table_name) {
        return tables.containsKey(table_name);
    }

    public HashSet<?> getTable(String table_name) {
        if (findTable(table_name)) return tables.get(table_name);
        return null;
    }

    public boolean removeByTableName(String table_name) {
        if (findTable(table_name)) {
            tables.remove(table_name, getTable(table_name));
            return true;
        }
        return false;
    }

    public int getNumberOfTables() {
        return tables.size();
    }

    public boolean isEmpty() {
        return tables.isEmpty();
    }

    public void addTable(String table_name, HashSet<?> table_data)
    {
        if (!findTable(table_name)) {
            tables.put(table_name, table_data);
        }
    }

    public int getNumOfEntriesInTable(String table_name) {
        if (findTable(table_name)) {
            return tables.get(table_name).size();
        }
        return -1;
    }

    public boolean setNewTableName(String old_name, String new_name) {
        if (!findTable(new_name) && findTable(old_name)) {
            HashSet<?> tableCopy = (HashSet<?>) getTable(old_name).clone();
            tables.remove(old_name, getTable(old_name));
            tables.put(new_name, tableCopy);
            return true;
        }
        return false;
    }

    public BasePersistence() {
        tables = new Hashtable<>();
    }

    @Override
    public String toString() {
        return "BasePersistence{" +
                "tables=" + tables +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePersistence that = (BasePersistence) o;
        return tables.equals(that.tables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tables);
    }
}
