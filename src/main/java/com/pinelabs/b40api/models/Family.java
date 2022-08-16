package com.pinelabs.b40api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Family {

    @Id
    @GeneratedValue
    private Long id;
    private String familyName;
    private Float lat;
    private Float lon;
    private int numberOfChildren;
    private Double householdIncome;
    private String religion;
    private String race;
    private Integer familySize;

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", numberOfChildren=" + numberOfChildren +
                ", householdIncome=" + householdIncome +
                ", religion='" + religion + '\'' +
                ", race='" + race + '\'' +
                ", familySize=" + familySize +
                '}';
    }
}
