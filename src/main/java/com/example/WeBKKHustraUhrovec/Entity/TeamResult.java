package com.example.WeBKKHustraUhrovec.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team_result")
public class TeamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_result_id")
    @Getter
    @Setter
    private int teamResultId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @Getter
    @Setter
    private Team team;

    @ManyToOne
    @JoinColumn(name = "result_id")
    @Getter
    @Setter
    private Result result;

    @Column(name = "score")
    @PositiveOrZero(message = "Score must be greater than or equal to 0")
    @Getter
    @Setter
    private int score;

    @Column(name = "match_result")
    @Getter
    @Setter
    private String matchResult;

    public TeamResult(int teamResultId, Team team, int score, String matchResult) {
        this.teamResultId = teamResultId;
        this.team = team;
        this.score = score;
        this.matchResult = matchResult;
    }

    public TeamResult() {
    }
}
