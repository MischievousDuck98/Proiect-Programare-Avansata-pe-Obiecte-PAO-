package repository;

import java.util.*;

public class Region extends TableEntry{
    private Integer region_id;
    private String  region_name;

    public Integer getRegion_id() {
        return this.region_id;
    }

    public String getRegion_name() {
        return this.region_name;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public Region() {
        setRegion_id(0);
        setRegion_name("");
    }

    @Override
    public String toString() {
        return "Region{" +
                "region_id=" + getRegion_id() +
                ", region_name='" + getRegion_name() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return region_id.equals(region.region_id) &&
                Objects.equals(region_name, region.region_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region_id, region_name);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
