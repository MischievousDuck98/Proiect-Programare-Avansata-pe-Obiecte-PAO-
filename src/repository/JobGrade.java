package repository;

import java.util.*;

public class JobGrade extends TableEntry {
    private String grade_level;
    private Double lowest_sal;
    private Double highest_sal;

    public String getGrade_level() {
        return this.grade_level;
    }

    public Double getLowest_sal() {
        return this.lowest_sal;
    }

    public Double getHighest_sal() {
        return this.highest_sal;
    }

    public void setGrade_level(String grade_level) {
        this.grade_level = grade_level;
    }

    public void setLowest_sal(Double lowest_sal) {
        this.lowest_sal = lowest_sal;
    }

    public void setHighest_sal(Double highest_sal) {
        this.highest_sal = highest_sal;
    }

    public JobGrade() {
        setGrade_level("");
        setLowest_sal(0.0);
        setHighest_sal(0.0);
    }

    @Override
    public String toString() {
        return "JobGrade{" +
                "grade_level='" + getGrade_level() + '\'' +
                ", lowest_sal=" + getLowest_sal() +
                ", highest_sal=" + getHighest_sal() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobGrade jobGrade = (JobGrade) o;
        return Objects.equals(grade_level, jobGrade.grade_level) &&
                Objects.equals(lowest_sal, jobGrade.lowest_sal) &&
                Objects.equals(highest_sal, jobGrade.highest_sal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade_level, lowest_sal, highest_sal);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
