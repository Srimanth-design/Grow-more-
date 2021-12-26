package com.growmore.model;

import lombok.*;

import javax.persistence.*;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Analyst {

    @Id
    @Column(name = "analystid")
    @GeneratedValue(generator = "analyst_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "analyst_seq", sequenceName = "analyst_sequence", allocationSize = 1, initialValue = 300)
    private Integer analystId;
    private String name;
    private String gender;
    private String degree;
    private int experience;
    private double rating;

    /**
     *
     * @param name
     * @param gender
     * @param degree
     * @param experience
     * @param rating
     */

    public Analyst(String name, String gender, String degree, int experience, double rating) {
        this.name = name;
        this.gender = gender;
        this.degree = degree;
        this.experience = experience;
        this.rating = rating;
    }
}
