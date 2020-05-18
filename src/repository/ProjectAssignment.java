package repository;

import java.util.*;

public class ProjectAssignment extends TableEntry{
    private Integer project_id;
    private Integer employee_id;
    private Date    start_date;
    private Date    end_date;

    public Integer getProject_id() {
        return this.project_id;
    }

    public Integer getEmployee_id() {
        return this.employee_id;
    }

    public Date getStart_date() {
        return (Date) this.start_date.clone();
    }

    public Date getEnd_date() {
        return (Date)  this.end_date.clone();
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = (Date) start_date.clone();
    }

    public void setEnd_date(Date end_date) {
        this.end_date = (Date) end_date.clone();
    }

    public ProjectAssignment() {
        setProject_id(0);
        setEmployee_id(0);
        Date placeholderDate = new Date();
        setStart_date(placeholderDate);
        setEnd_date(placeholderDate);
    }

    @Override
    public String toString() {
        return "ProjectAssignment{" +
                "project_id=" + getProject_id() +
                ", employee_id=" + getEmployee_id() +
                ", start_date=" + getStart_date() +
                ", end_date=" + getEnd_date() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAssignment that = (ProjectAssignment) o;
        return project_id.equals(that.project_id) &&
                employee_id.equals(that.employee_id) &&
                Objects.equals(start_date, that.start_date) &&
                Objects.equals(end_date, that.end_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, employee_id, start_date, end_date);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
