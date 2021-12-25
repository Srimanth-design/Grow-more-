package com.growmore.model;

import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString
@Entity
public class Farmer {

    @Id
    @Column(name = "farmerid")
    @GeneratedValue(generator = "farmer_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "farmer_seq", sequenceName = "farmer_sequence", allocationSize = 1, initialValue = 1)
    private Integer farmerId;
    @Column(length = 20)
    private String name;
    private int age;
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    Set<Problem>problems;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farmid")
    private FarmDetails farmDetails;

    public Farmer(String name, int age, String gender, Set<Problem> problems, FarmDetails farmDetails) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.problems = problems;
        this.farmDetails = farmDetails;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FarmDetails getFarmDetails() {
        return farmDetails;
    }

    public void setFarmDetails(FarmDetails farmDetails) {
        this.farmDetails = farmDetails;
    }
}
