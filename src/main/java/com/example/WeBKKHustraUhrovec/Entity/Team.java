package com.example.WeBKKHustraUhrovec.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamId;

    @Column(name = "team_name", length = 255)
    @NotEmpty(message = "Team name must not be empty")
    private String teamName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();


    @Column(name = "points")
    private int points;

    @Column(name = "thrown_frames")
    private int thrownFrames;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column(name = "matches_won")
    private int matchesWon;

    @Column(name = "matches_lost")
    private int matchesLost;

    @Column(name = "matches_draw")
    private int matchesDraw;

    public Team(String teamName, int points, int thrownFrames,
                int matchesPlayed, int matchesWon, int matchesLost, int matchesDraw) {
        this.teamName = teamName;
        this.points = points;
        this.thrownFrames = thrownFrames;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesDraw = matchesDraw;
    }

    public Team() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getThrownFrames() {
        return thrownFrames;
    }

    public void setThrownFrames(int thrownFrames) {
        this.thrownFrames = thrownFrames;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getMatchesDraw() {
        return matchesDraw;
    }

    public void setMatchesDraw(int matchesDraw) {
        this.matchesDraw = matchesDraw;
    }
}
