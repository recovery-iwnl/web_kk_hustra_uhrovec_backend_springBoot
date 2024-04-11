package com.example.WeBKKHustraUhrovec.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="league_year")
public class LeagueYear {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "year_id")
    @Getter
    @Setter
    private int yearId;

    @Column(name = "year")
    @Getter
    @Setter
    private String year;

    public LeagueYear(String year) {
        this.year = year;
    }

    public LeagueYear() {
    }
}
