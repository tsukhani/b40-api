package com.pinelabs.b40api.Model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Family {

    //Attributes
    @Id
    @GeneratedValue
    private Long id; //Primary Key
    private String familyName;
    private String location;
    private int numberOfChildren;
    private Double householdIncome;
    private String religion;
    private String race;


    //Constructors

    //To save into DB;
    public Family(Long id, String familyName, String location, int numberOfChildren, Double householdIncome, String religion, String race) {
        this.id = id;
        this.familyName = familyName;
        this.location = location;
        this.numberOfChildren = numberOfChildren;
        this.householdIncome = householdIncome;
        this.religion = religion;
        this.race = race;
    }

    public Family() {

    }


    //Getters
    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public Double getHouseholdIncome() {
        return householdIncome;
    }

    public String getReligion() {
        return religion;
    }

    public String getRace() {
        return race;
    }


    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setHouseholdIncome(Double householdIncome) {
        this.householdIncome = householdIncome;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", location='" + location + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", householdIncome=" + householdIncome +
                ", religion='" + religion + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
