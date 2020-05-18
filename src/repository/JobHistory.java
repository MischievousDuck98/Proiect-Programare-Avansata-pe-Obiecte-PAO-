package repository;

import java.util.*;

public class JobHistory extends TableEntry {
    private Integer employee_id;
    private Integer department_id;
    private Date    start_date;
    private Date    end_date;
    private String  job_id;

    public Integer getEmployee_id() {
        return this.employee_id;
    }

    public Integer getDepartment_id() {
        return this.department_id;
    }

    public Date getStart_date() {
        return (Date) this.start_date.clone();
    }

    public Date getEnd_date() {
        return (Date) this.end_date.clone();
    }

    public String getJob_id() {
        return this.job_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = (Date) start_date.clone();
    }

    public void setEnd_date(Date end_date) {
        this.end_date = (Date) end_date.clone();
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public JobHistory() {
        setEmployee_id(0);
        setDepartment_id(0);
        Date placeholderDate = new Date();
        setStart_date(placeholderDate);
        setEnd_date(placeholderDate);
        setJob_id("");
    }

    @Override
    public String toString() {
        return "JobHistory{" +
                "employee_id=" + getEmployee_id() +
                ", department_id=" + getDepartment_id() +
                ", start_date=" + getStart_date() +
                ", end_date=" + getEnd_date() +
                ", job_id='" + getJob_id() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHistory that = (JobHistory) o;
        return employee_id.equals(that.employee_id) &&
                Objects.equals(department_id, that.department_id) &&
                start_date.equals(that.start_date) &&
                end_date.equals(that.end_date) &&
                job_id.equals(that.job_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, department_id, start_date, end_date, job_id);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
