package com.growmore.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class FarmDetails {

    @Id
    @Column(name = "farmid")
    @GeneratedValue(generator = "farm_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "farm_seq", sequenceName = "farm_sequence", allocationSize = 1, initialValue = 100)
    private Integer farmId;
    private String farm;
    @Column(name = "farmarea")
    private String farmArea;
    private String soil;
    private String city;
    @Column(name = "zipcode")
    private int zipCode;

    public FarmDetails(String farm, String farmArea, String soil, String city, int zipCode) {
        this.farm = farm;
        this.farmArea = farmArea;
        this.soil = soil;
        this.city = city;
        this.zipCode = zipCode;
    }
}
