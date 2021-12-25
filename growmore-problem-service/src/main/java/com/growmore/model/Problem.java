package com.growmore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;



@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Problem {
    @Id
    @Column(name = "problemid")
    @GeneratedValue(generator = "problem_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "problem_seq", sequenceName = "problem_sequence", allocationSize = 1, initialValue = 200)
    private Integer problemId;
    @Column(length = 100)
    String problem;
    @Enumerated(EnumType.STRING)
    private Intensity intensity;
    String affectedAreaImg;
    @Enumerated(EnumType.STRING)
    private Fertilizers fertilizers;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "problem_solution", joinColumns = @JoinColumn(name = "problemid"), inverseJoinColumns = @JoinColumn(name = "solutionid"))
    @ToString.Exclude
    private Set<Solution> solutions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="analystid")

    private Analyst analyst;

    public Problem(String problem, Intensity intensity, String affectedAreaImg, Fertilizers fertilizers, Set<Solution> solutions, Analyst analyst) {
        this.problem = problem;
        this.intensity = intensity;
        this.affectedAreaImg = affectedAreaImg;
        this.fertilizers = fertilizers;
        this.solutions = solutions;
        this.analyst = analyst;
    }
}
