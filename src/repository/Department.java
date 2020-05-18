package repository;

import java.util.*;

public class Department extends TableEntry{
    private Integer department_id;
    private Integer manager_id;
    private Integer location_id;
    private String  department_name;

    public Integer getDepartment_id() {
        return this.department_id;
    }

    public Integer getManager_id() {
        return this.manager_id;
    }

    public Integer getLocation_id() {
        return this.location_id;
    }

    public String getDepartment_name() {
        return this.department_name;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Department() {
        setDepartment_id(0);
        setManager_id(0);
        setLocation_id(0);
        setDepartment_name("");
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + getDepartment_id() +
                ", manager_id=" + getManager_id() +
                ", location_id=" + getLocation_id() +
                ", department_name='" + getDepartment_name() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return department_id.equals(that.department_id) &&
                Objects.equals(manager_id, that.manager_id) &&
                Objects.equals(location_id, that.location_id) &&
                department_name.equals(that.department_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id, manager_id, location_id, department_name);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
