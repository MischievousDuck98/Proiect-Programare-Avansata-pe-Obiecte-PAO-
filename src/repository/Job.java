package repository;

import java.util.*;

public class Job extends TableEntry{
    private String job_id;
    private String job_title;
    private Double min_salary;
    private Double max_salary;

    public String getJob_id() {
        return this.job_id;
    }

    public String getJob_title() {
        return this.job_title;
    }

    public Double getMin_salary() {
        return this.min_salary;
    }

    public Double getMax_salary() {
        return this.max_salary;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setMin_salary(Double min_salary) {
        this.min_salary = min_salary;
    }

    public void setMax_salary(Double max_salary) {
        this.max_salary = max_salary;
    }

    public Job() {
        setJob_id("");
        setJob_title("");
        setMin_salary(0.0);
        setMax_salary(0.0);
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id='" + getJob_id() + '\'' +
                ", job_title='" + getJob_title() + '\'' +
                ", min_salary=" + getMin_salary() +
                ", max_salary=" + getMax_salary() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return job_id.equals(job.job_id) &&
                job_title.equals(job.job_title) &&
                Objects.equals(min_salary, job.min_salary) &&
                Objects.equals(max_salary, job.max_salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id, job_title, min_salary, max_salary);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
