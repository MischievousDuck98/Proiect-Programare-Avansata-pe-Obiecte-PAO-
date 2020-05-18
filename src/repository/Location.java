package repository;

import java.util.*;

public class Location extends TableEntry{
    private Integer location_id;
    private String  street_address;
    private String  postal_code;
    private String  city;
    private String  state_province;
    private String  country_id;

    public Integer getLocation_id() {
        return this.location_id;
    }

    public String getStreet_address() {
        return this.street_address;
    }

    public String getPostal_code() {
        return this.postal_code;
    }

    public String getCity() {
        return this.city;
    }

    public String getState_province() {
        return this.state_province;
    }

    public String getCountry_id() {
        return this.country_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Location() {
        setLocation_id(0);
        setStreet_address("");
        setPostal_code("");
        setCity("");
        setState_province("");
        setCountry_id("");
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + getLocation_id() +
                ", street_address='" + getStreet_address() + '\'' +
                ", postal_code='" + getPostal_code() + '\'' +
                ", city='" + getCity() + '\'' +
                ", state_province='" + getState_province() + '\'' +
                ", country_id='" + getCountry_id() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return location_id.equals(location.location_id) &&
                Objects.equals(street_address, location.street_address) &&
                Objects.equals(postal_code, location.postal_code) &&
                city.equals(location.city) &&
                Objects.equals(state_province, location.state_province) &&
                Objects.equals(country_id, location.country_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location_id, street_address, postal_code, city, state_province, country_id);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
