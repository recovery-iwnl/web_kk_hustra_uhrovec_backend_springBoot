package com.example.WeBKKHustraUhrovec.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_result")
public class PlayerResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_result_id")
    @Getter
    @Setter
    private int scoreId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @Getter
    @Setter
    private Player player;

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

    public PlayerResult(int scoreId, Player player, Result result, int score, String matchResult) {
        this.scoreId = scoreId;
        this.player = player;
        this.result = result;
        this.score = score;
        this.matchResult = matchResult;
    }

    public PlayerResult() {
    }
}
