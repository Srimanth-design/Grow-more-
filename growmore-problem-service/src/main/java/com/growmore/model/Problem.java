package com.growmore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

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

    /**
     *
     * @param problem
     * @param intensity
     * @param affectedAreaImg
     * @param fertilizers
     * @param solutions
     * @param analyst
     */

    public Problem(String problem, Intensity intensity, String affectedAreaImg, Fertilizers fertilizers, Set<Solution> solutions, Analyst analyst) {
        this.problem = problem;
        this.intensity = intensity;
        this.affectedAreaImg = affectedAreaImg;
        this.fertilizers = fertilizers;
        this.solutions = solutions;
        this.analyst = analyst;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public String getAffectedAreaImg() {
        return affectedAreaImg;
    }

    public void setAffectedAreaImg(String affectedAreaImg) {
        this.affectedAreaImg = affectedAreaImg;
    }

    public Fertilizers getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(Fertilizers fertilizers) {
        this.fertilizers = fertilizers;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(Set<Solution> solutions) {
        this.solutions = solutions;
    }


}
