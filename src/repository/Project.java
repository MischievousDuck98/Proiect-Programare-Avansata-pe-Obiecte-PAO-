package repository;

import java.util.*;

public class Project extends TableEntry{
    private Integer project_id;
    private Double  budget;
    private Integer project_manager;
    private String  project_name;
    private Date    start_date;
    private Date    delivery_date;
    private Date    deadline;

    public Integer getProject_id() {
        return this.project_id;
    }

    public Double getBudget() {
        return this.budget;
    }

    public Integer getProject_manager() {
        return this.project_manager;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public Date getStart_date() {
        return (Date) this.start_date.clone();
    }

    public Date getDelivery_date() {
        return (Date) this.delivery_date.clone();
    }

    public Date getDeadline() {
        return (Date) this.deadline.clone();
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setProject_manager(Integer project_manager) {
        this.project_manager = project_manager;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setStart_date(Date start_date) {
        this.start_date = (Date) start_date.clone();
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = (Date) delivery_date.clone();
    }

    public void setDeadline(Date deadline) {
        this.deadline = (Date) deadline.clone();
    }

    public Project() {
        setProject_id(0);
        setProject_name("");
        setBudget(0.0);
        Date placeholderDate = new Date();
        setStart_date(placeholderDate);
        setDelivery_date(placeholderDate);
        setDeadline(placeholderDate);
        setProject_manager(0);
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + getProject_id() +
                ", budget=" + getBudget() +
                ", project_manager=" + getProject_manager() +
                ", project_name='" + getProject_name() + '\'' +
                ", start_date=" + getStart_date() +
                ", delivery_date=" + getDelivery_date() +
                ", deadline=" + getDeadline() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return project_id.equals(project.project_id) &&
                Objects.equals(budget, project.budget) &&
                Objects.equals(project_manager, project.project_manager) &&
                Objects.equals(project_name, project.project_name) &&
                Objects.equals(start_date, project.start_date) &&
                Objects.equals(delivery_date, project.delivery_date) &&
                Objects.equals(deadline, project.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, budget, project_manager, project_name, start_date, delivery_date, deadline);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
