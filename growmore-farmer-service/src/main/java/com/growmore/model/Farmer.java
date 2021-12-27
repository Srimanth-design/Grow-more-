package com.growmore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Farmer {

    @Id
    @Column(name = "farmerid")
    @GeneratedValue(generator = "farmer_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "farmer_seq", sequenceName = "farmerSequence", allocationSize = 1, initialValue = 1)
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

    /**
     *
     * @param name
     * @param age
     * @param gender
     * @param problems
     * @param farmDetails
     */
    public Farmer(String name, int age, String gender, Set<Problem> problems, FarmDetails farmDetails) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.problems = problems;
        this.farmDetails = farmDetails;
    }


}
