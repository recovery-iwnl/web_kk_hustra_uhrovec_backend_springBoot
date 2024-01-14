package com.example.WeBKKHustraUhrovec.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="player")
public class Player {

    @Id
    @Column(name = "player_id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerID;

    @Column(name = "player_name", length = 255)
    @NotEmpty(message = "Name must not be empty")
    @Pattern(regexp = "^[a-zA-ZščťžýáíéúäôöüěřščřžýáíéúäôóöüěřščřžľďťňĺŕŠČŤŽÝÁÍÉÚÄÔÓÖÜĚŘŠČŘŽĹĽ]+$", message = "Name can only contain letters and special characters")
    private String name;

    @Column(name = "player_surname", length = 255)
    @NotEmpty(message = "Surname must not be empty")
    @Pattern(regexp = "^[a-zA-ZščťžýáíéúäôöüěřščřžýáíéúäôóöüěřščřžľďťňĺŕŠČŤŽÝÁÍÉÚÄÔÓÖÜĚŘŠČŘŽĹĽ]+$", message = "Surname can only contain letters and special characters")
    private String surname;

    @Column(name = "player_age", length = 255)
    @Positive(message = "Age must be greater than 0")
    private int age;

    @Column(name = "player_points", length = 255)
    @PositiveOrZero(message = "Points must be greater than or equal to 0")
    private int points;

    @Column(name = "matches_played", length = 255)
    @PositiveOrZero(message = "Matches played must be greater than or equal to 0")
    private int matchesPlayed;
    @Column(name = "players_best", length = 255)
    @PositiveOrZero(message = "Players best must be greater than or equal to 0")
    private int playersBest;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    public Player(String name, String surname, int age, int points, int matchesPlayed, int playersBest) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.points = points;
        this.matchesPlayed = matchesPlayed;
        this.playersBest = playersBest;
    }

    public Player() {

    }

    public int getPlayersBest() {
        return playersBest;
    }

    public void setPlayersBest(int playersBest) {
        this.playersBest = playersBest;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
