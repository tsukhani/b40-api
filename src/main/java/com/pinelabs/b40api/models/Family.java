package com.pinelabs.b40api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "family")
@SQLDelete(sql = "UPDATE family SET deleted_at = NOW() WHERE id= ?")
@Where(clause = "deleted_at = null")
public class Family extends EntityModel {

    private String familyName;
    private Float lat;
    private Float lon;
    private Integer numberOfChildren;
    private Double householdIncome;
    private String religion;
    private String race;
    private Integer familySize;

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", numberOfChildren=" + numberOfChildren +
                ", householdIncome=" + householdIncome +
                ", religion='" + religion + '\'' +
                ", race='" + race + '\'' +
                ", familySize=" + familySize +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}

