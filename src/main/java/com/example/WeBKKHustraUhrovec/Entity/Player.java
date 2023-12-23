package com.example.WeBKKHustraUhrovec.Entity;


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
    @Pattern(regexp = "^[a-zA-ZščťžýáíéúäôöüěřščřžýáíéúäôöüěřščřžľďťňĺŕŠČŤŽÝÁÍÉÚÄÔÖÜĚŘŠČŘŽĹĽ]+$", message = "Name can only contain letters and special characters")
    private String name;

    @Column(name = "player_surname", length = 255)
    @NotEmpty(message = "Surname must not be empty")
    @Pattern(regexp = "^[a-zA-ZščťžýáíéúäôöüěřščřžýáíéúäôöüěřščřžľďťňĺŕŠČŤŽÝÁÍÉÚÄÔÖÜĚŘŠČŘŽĹĽ]+$", message = "Surname can only contain letters and special characters")
    private String surname;

    @Column(name = "player_age", length = 255)
    @NotEmpty(message = "Age must not be empty")
    @Positive(message = "Age must be greater than 0")
    private String age;

    @Column(name = "player_points", length = 255)
    @NotEmpty(message = "Points must not be empty")
    @PositiveOrZero(message = "Points must be greater than or equal to 0")
    private String points;


    public Player(int playerID, String name, String surname, String age, String points) {
        this.playerID = playerID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.points = points;
    }

    public Player() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
