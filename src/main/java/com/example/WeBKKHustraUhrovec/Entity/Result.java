package com.example.WeBKKHustraUhrovec.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    @Getter
    @Setter
    private int resultId;

    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Getter
    @Setter
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "team_home_id")
    @Getter
    @Setter
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id")
    @Getter
    @Setter
    private Team teamAway;

    @ManyToOne
    @JoinColumn(name = "player1_home_id")
    @Getter
    @Setter
    private Player player1Home;

    @ManyToOne
    @JoinColumn(name = "player2_home_id")
    @Getter
    @Setter
    private Player player2Home;
    @ManyToOne
    @JoinColumn(name = "player3_home_id")
    @Getter
    @Setter
    private Player player3Home;
    @ManyToOne
    @JoinColumn(name = "player4_home_id")
    @Getter
    @Setter
    private Player player4Home;
    @ManyToOne
    @JoinColumn(name = "player5_home_id")
    @Getter
    @Setter
    private Player player5Home;
    @ManyToOne
    @JoinColumn(name = "player6_home_id")
    @Getter
    @Setter
    private Player player6Home;

    @Column(name = "player1_score_home")
    @PositiveOrZero(message = "player1ScoreHome must be greater than or equal to 0")
    @Getter
    @Setter
    private int player1ScoreHome;

    @Column(name = "player1_points_home")
    @PositiveOrZero(message = "player1PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player1PointsHome;

    @Column(name = "player2_score_home")
    @PositiveOrZero(message = "player2ScoreHome must be greater than or equal to 0")
    @Getter
    @Setter
    private int player2ScoreHome;

    @Column(name = "player2_points_home")
    @PositiveOrZero(message = "player2PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player2PointsHome;

    @Column(name = "player3_score_home")
    @PositiveOrZero(message = "player3ScoreHome must be greater than or equal to 0")
    @Getter
    @Setter
    private int player3ScoreHome;

    @Column(name = "player3_points_home")
    @PositiveOrZero(message = "player3PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player3PointsHome;

    @Column(name = "player4_score_home")
    @PositiveOrZero(message = "player4ScoreHome must be greater than or equal to 0")
    @Getter
    @Setter
    private int player4ScoreHome;

    @Column(name = "player4_points_home")
    @PositiveOrZero(message = "player4PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player4PointsHome;

    @Column(name = "player5_score_home")
    @PositiveOrZero(message = "player5ScoreHome must be greater than or equal to 0")
    @Getter
    @Setter
    private int player5ScoreHome;

    @Column(name = "player5_points_home")
    @PositiveOrZero(message = "player5PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player5PointsHome;

    @Getter
    @Setter
    @Column(name = "player6_score_home")
    @PositiveOrZero(message = "player6ScoreHome must be greater than or equal to 0")
    private int player6ScoreHome;

    @Column(name = "player6_points_home")
    @PositiveOrZero(message = "player6PointsHome must be greater than or equal to 0")
    @Getter
    @Setter
    private double player6PointsHome;

    @ManyToOne
    @JoinColumn(name = "player1_away_id")
    @Getter
    @Setter
    private Player player1Away;
    @ManyToOne
    @JoinColumn(name = "player2_away_id")
    @Getter
    @Setter
    private Player player2Away;
    @ManyToOne
    @JoinColumn(name = "player3_away_id")
    @Getter
    @Setter
    private Player player3Away;
    @ManyToOne
    @JoinColumn(name = "player4_away_id")
    @Getter
    @Setter
    private Player player4Away;
    @ManyToOne
    @JoinColumn(name = "player5_away_id")
    @Getter
    @Setter
    private Player player5Away;
    @ManyToOne
    @JoinColumn(name = "player6_away_id")
    @Getter
    @Setter
    private Player player6Away;

    @Column(name = "player1_score_away")
    @PositiveOrZero(message = "player1ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player1ScoreAway;

    @Column(name = "player1_points_away")
    @PositiveOrZero(message = "player1PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player1PointsAway;

    @Column(name = "player2_score_away")
    @PositiveOrZero(message = "player2ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player2ScoreAway;

    @Column(name = "player2_points_away")
    @PositiveOrZero(message = "player2PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player2PointsAway;

    @Column(name = "player3_score_away")
    @PositiveOrZero(message = "player3ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player3ScoreAway;

    @Column(name = "player3_points_away")
    @PositiveOrZero(message = "player3PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player3PointsAway;

    @Column(name = "player4_score_away")
    @PositiveOrZero(message = "player4ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player4ScoreAway;

    @Column(name = "player4_points_away")
    @PositiveOrZero(message = "player4PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player4PointsAway;

    @Column(name = "player5_score_away")
    @PositiveOrZero(message = "player5ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player5ScoreAway;

    @Column(name = "player5_points_away")
    @PositiveOrZero(message = "player5PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player5PointsAway;

    @Column(name = "player6_score_away")
    @PositiveOrZero(message = "player6ScoreAway must be greater than or equal to 0")
    @Getter
    @Setter
    private int player6ScoreAway;

    @Column(name = "player6_points_away")
    @PositiveOrZero(message = "player6PointsAway must be greater than or equal to 0")
    @Getter
    @Setter
    private double player6PointsAway;

    @Column(name = "team1_score_overall")
    @PositiveOrZero(message = "team1ScoreOverall must be greater than or equal to 0")
    @Getter
    @Setter
    private int team1ScoreOverall;

    @Column(name = "team2_score_overall")
    @PositiveOrZero(message = "team2ScoreOverall must be greater than or equal to 0")
    @Getter
    @Setter
    private int team2ScoreOverall;

    @Column(name = "team1_points_overall")
    @PositiveOrZero(message = "team1PointsOverall must be greater than or equal to 0")
    @Getter
    @Setter
    private double team1PointsOverall;

    @Column(name = "team2_points_overall")
    @PositiveOrZero(message = "team2PointsOverall must be greater than or equal to 0")
    @Getter
    @Setter
    private double team2PointsOverall;

    public Result(LocalDate date, Team teamHome, Team teamAway, Player player1Home, Player player2Home, Player player3Home, Player player4Home, Player player5Home, Player player6Home, int player1ScoreHome, double player1PointsHome, int player2ScoreHome, double player2PointsHome, int player3ScoreHome, double player3PointsHome, int player4ScoreHome, double player4PointsHome, int player5ScoreHome, double player5PointsHome, int player6ScoreHome, double player6PointsHome, Player player1Away, Player player2Away, Player player3Away, Player player4Away, Player player5Away, Player player6Away, int player1ScoreAway, double player1PointsAway, int player2ScoreAway, double player2PointsAway, int player3ScoreAway, double player3PointsAway, int player4ScoreAway, double player4PointsAway, int player5ScoreAway, double player5PointsAway, int player6ScoreAway, double player6PointsAway, int team1ScoreOverall, int team2ScoreOverall, double team1PointsOverall, double team2PointsOverall) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;

        this.player1Home = player1Home;
        this.player2Home = player2Home;
        this.player3Home = player3Home;
        this.player4Home = player4Home;
        this.player5Home = player5Home;
        this.player6Home = player6Home;

        this.player1ScoreHome = player1ScoreHome;
        this.player1PointsHome = player1PointsHome;
        this.player2ScoreHome = player2ScoreHome;
        this.player2PointsHome = player2PointsHome;
        this.player3ScoreHome = player3ScoreHome;
        this.player3PointsHome = player3PointsHome;
        this.player4ScoreHome = player4ScoreHome;
        this.player4PointsHome = player4PointsHome;
        this.player5ScoreHome = player5ScoreHome;
        this.player5PointsHome = player5PointsHome;
        this.player6ScoreHome = player6ScoreHome;
        this.player6PointsHome = player6PointsHome;

        this.player1Away = player1Away;
        this.player2Away = player2Away;
        this.player3Away = player3Away;
        this.player4Away = player4Away;
        this.player5Away = player5Away;
        this.player6Away = player6Away;

        this.player1ScoreAway = player1ScoreAway;
        this.player1PointsAway = player1PointsAway;
        this.player2ScoreAway = player2ScoreAway;
        this.player2PointsAway = player2PointsAway;
        this.player3ScoreAway = player3ScoreAway;
        this.player3PointsAway = player3PointsAway;
        this.player4ScoreAway = player4ScoreAway;
        this.player4PointsAway = player4PointsAway;
        this.player5ScoreAway = player5ScoreAway;
        this.player5PointsAway = player5PointsAway;
        this.player6ScoreAway = player6ScoreAway;
        this.player6PointsAway = player6PointsAway;

        this.team1ScoreOverall = team1ScoreOverall;
        this.team2ScoreOverall = team2ScoreOverall;
        this.team1PointsOverall = team1PointsOverall;
        this.team2PointsOverall = team2PointsOverall;

        this.date = date;
    }
    public Result() {
    }
}
