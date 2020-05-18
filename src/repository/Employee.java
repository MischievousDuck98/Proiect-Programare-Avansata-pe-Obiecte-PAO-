package repository;

import java.util.*;

public class Employee extends TableEntry{
    private Integer employee_id;
    private Integer manager_id;
    private Integer department_id;
    private String  job_id;
    private String  first_name;
    private String  last_name;
    private String  email;
    private String  phone_number;
    private Date    hire_date;
    private Double  salary;
    private Double  commission_pct;

    public Date getHire_date() {
        return (Date) this.hire_date.clone();
    }

    public Double getCommission_pct() {
        return this.commission_pct;
    }

    public Double getSalary() {
        return this.salary;
    }

    public Integer getDepartment_id() {
        return this.department_id;
    }

    public Integer getEmployee_id() {
        return this.employee_id;
    }

    public Integer getManager_id() {
        return this.manager_id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getJob_id() {
        return this.job_id;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = (Date) hire_date.clone();
    }

    public void setCommission_pct(Double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setEmail(String email) { this.email = email; }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee() {
        setCommission_pct(0.0);
        setDepartment_id(0);
        setEmail("");
        setEmployee_id(0);
        setFirst_name("");
        setHire_date(new Date());
        setLast_name("");
        setJob_id("");
        setManager_id(0);
        setPhone_number("");
        setSalary(0.0);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + getEmployee_id() +
                ", manager_id=" + getManager_id() +
                ", department_id=" + getDepartment_id() +
                ", job_id='" + getJob_id() + '\'' +
                ", first_name='" + getFirst_name() + '\'' +
                ", last_name='" + getLast_name() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone_number='" + getPhone_number() + '\'' +
                ", hire_date=" + getHire_date() +
                ", salary=" + getSalary() +
                ", commission_pct=" + getCommission_pct() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_id.equals(employee.employee_id) &&
                Objects.equals(manager_id, employee.manager_id) &&
                Objects.equals(department_id, employee.department_id) &&
                job_id.equals(employee.job_id) &&
                Objects.equals(first_name, employee.first_name) &&
                last_name.equals(employee.last_name) &&
                email.equals(employee.email) &&
                Objects.equals(phone_number, employee.phone_number) &&
                hire_date.equals(employee.hire_date) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(commission_pct, employee.commission_pct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, job_id, manager_id, department_id);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
