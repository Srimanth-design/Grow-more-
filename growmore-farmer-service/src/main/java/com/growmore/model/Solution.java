package com.growmore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Solution {

    @Id
    @Column(name = "solutionid")
    @GeneratedValue(generator = "solution_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "solution_seq", sequenceName = "solution_sequence", allocationSize = 1, initialValue = 400)
    private Integer solutionId;
    private String solution;
    private String solutionImg;
    @Column(length = 100)
    private String description;
    private  String alternative;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "solutions")
    @JsonIgnore
    private Set<Problem> problems;

    /**
     *
     * @param solution
     * @param solutionImg
     * @param description
     * @param alternative
     */

    public Solution(String solution, String solutionImg, String description, String alternative) {
        this.solution = solution;
        this.solutionImg = solutionImg;
        this.description = description;
        this.alternative = alternative;
    }
}
