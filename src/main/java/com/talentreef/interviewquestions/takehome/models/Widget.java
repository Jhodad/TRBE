package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder = true)
public class Widget {

    // Widget class attributes
    @Valid
    @Id
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @Valid
    @Size(min = 5, max = 1000, message = "Description must be between 5 and 1000 characters")
    private String description;

    @Valid
    @DecimalMin(value = "1.00", message = "Price must be bigger than 1.00 and smaller than 20000.00")
    @DecimalMax(value = "20000.00", message = "Price must be bigger than 1.00 and smaller than 20000.00")
    @Digits(integer = 5, fraction = 2)
    private double price;

}
