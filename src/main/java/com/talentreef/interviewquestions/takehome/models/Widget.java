package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder = true)
public class Widget {

    @Id
    private String id;

    @Size(min = 3, max = 100, message ="Name must be between 3 and 100 characters")
    private String name;

    @Size(min = 5, max = 1000, message ="Description must be between 5 and 1000 characters")
    private String description;

    @DecimalMin("1.00")
    @DecimalMax("20000.00")
    @Digits(integer = 5, fraction = 2)
    private double price;

}
