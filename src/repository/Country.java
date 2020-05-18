package repository;

import java.util.*;

public class Country extends TableEntry{
    private Integer region_id;
    private String  country_id;
    private String  country_name;

    public Integer getRegion_id() {
        return this.region_id;
    }

    public String getCountry_id() {
        return this.country_id;
    }

    public String getCountry_name() {
        return this.country_name;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Country() {
        setRegion_id(0);
        setCountry_id("");
        setCountry_name("");
    }

    @Override
    public String toString() {
        return "Country{" +
                "region_id=" + getRegion_id() +
                ", country_id='" + getCountry_id() + '\'' +
                ", country_name='" + getCountry_name() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(region_id, country.region_id) &&
                country_id.equals(country.country_id) &&
                Objects.equals(country_name, country.country_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region_id, country_id, country_name);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
