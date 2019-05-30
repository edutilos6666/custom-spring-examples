package com.example.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */

@Data
@NoArgsConstructor
public class SoccerPlayer implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Double wage;
    private String country;
    private String team;

    public SoccerPlayer(String name, Integer age, Double wage, String country, String team) {
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.country = country;
        this.team = team;
    }
}
