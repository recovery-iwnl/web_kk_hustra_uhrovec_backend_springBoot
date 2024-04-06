package com.example.WeBKKHustraUhrovec.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private int resultId;

    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private LeagueYear leagueYear;


    @ManyToOne
    @JoinColumn(name = "team_home_id")
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id")
    private Team teamAway;

    @ManyToOne
    @JoinColumn(name = "player1_home_id")
    private Player player1Home;

    @ManyToOne
    @JoinColumn(name = "player2_home_id")
    private Player player2Home;

    @ManyToOne
    @JoinColumn(name = "player3_home_id")
    private Player player3Home;

    @ManyToOne
    @JoinColumn(name = "player4_home_id")
    private Player player4Home;

    @ManyToOne
    @JoinColumn(name = "player5_home_id")

    private Player player5Home;
    @ManyToOne
    @JoinColumn(name = "player6_home_id")
    private Player player6Home;

    @Column(name = "player1_score_home")
    @PositiveOrZero(message = "player1ScoreHome must be greater than or equal to 0")
    private int player1ScoreHome;

    @Column(name = "player1_points_home")
    @PositiveOrZero(message = "player1PointsHome must be greater than or equal to 0")
    private double player1PointsHome;

    @Column(name = "player2_score_home")
    @PositiveOrZero(message = "player2ScoreHome must be greater than or equal to 0")
    private int player2ScoreHome;

    @Column(name = "player2_points_home")
    @PositiveOrZero(message = "player2PointsHome must be greater than or equal to 0")
    private double player2PointsHome;

    @Column(name = "player3_score_home")
    @PositiveOrZero(message = "player3ScoreHome must be greater than or equal to 0")
    private int player3ScoreHome;

    @Column(name = "player3_points_home")
    @PositiveOrZero(message = "player3PointsHome must be greater than or equal to 0")
    private double player3PointsHome;

    @Column(name = "player4_score_home")
    @PositiveOrZero(message = "player4ScoreHome must be greater than or equal to 0")
    private int player4ScoreHome;

    @Column(name = "player4_points_home")
    @PositiveOrZero(message = "player4PointsHome must be greater than or equal to 0")
    private double player4PointsHome;

    @Column(name = "player5_score_home")
    @PositiveOrZero(message = "player5ScoreHome must be greater than or equal to 0")
    private int player5ScoreHome;

    @Column(name = "player5_points_home")
    @PositiveOrZero(message = "player5PointsHome must be greater than or equal to 0")
    private double player5PointsHome;

    @Column(name = "player6_score_home")
    @PositiveOrZero(message = "player6ScoreHome must be greater than or equal to 0")
    private int player6ScoreHome;

    @Column(name = "player6_points_home")
    @PositiveOrZero(message = "player6PointsHome must be greater than or equal to 0")
    private double player6PointsHome;

    @ManyToOne
    @JoinColumn(name = "player1_away_id")
    private Player player1Away;

    @ManyToOne
    @JoinColumn(name = "player2_away_id")
    private Player player2Away;

    @ManyToOne
    @JoinColumn(name = "player3_away_id")
    private Player player3Away;

    @ManyToOne
    @JoinColumn(name = "player4_away_id")
    private Player player4Away;

    @ManyToOne
    @JoinColumn(name = "player5_away_id")
    private Player player5Away;

    @ManyToOne
    @JoinColumn(name = "player6_away_id")
    private Player player6Away;

    @Column(name = "player1_score_away")
    @PositiveOrZero(message = "player1ScoreAway must be greater than or equal to 0")
    private int player1ScoreAway;

    @Column(name = "player1_points_away")
    @PositiveOrZero(message = "player1PointsAway must be greater than or equal to 0")
    private double player1PointsAway;

    @Column(name = "player2_score_away")
    @PositiveOrZero(message = "player2ScoreAway must be greater than or equal to 0")
    private int player2ScoreAway;

    @Column(name = "player2_points_away")
    @PositiveOrZero(message = "player2PointsAway must be greater than or equal to 0")
    private double player2PointsAway;

    @Column(name = "player3_score_away")
    @PositiveOrZero(message = "player3ScoreAway must be greater than or equal to 0")
    private int player3ScoreAway;

    @Column(name = "player3_points_away")
    @PositiveOrZero(message = "player3PointsAway must be greater than or equal to 0")
    private double player3PointsAway;

    @Column(name = "player4_score_away")
    @PositiveOrZero(message = "player4ScoreAway must be greater than or equal to 0")
    private int player4ScoreAway;

    @Column(name = "player4_points_away")
    @PositiveOrZero(message = "player4PointsAway must be greater than or equal to 0")
    private double player4PointsAway;

    @Column(name = "player5_score_away")
    @PositiveOrZero(message = "player5ScoreAway must be greater than or equal to 0")
    private int player5ScoreAway;

    @Column(name = "player5_points_away")
    @PositiveOrZero(message = "player5PointsAway must be greater than or equal to 0")
    private double player5PointsAway;

    @Column(name = "player6_score_away")
    @PositiveOrZero(message = "player6ScoreAway must be greater than or equal to 0")
    private int player6ScoreAway;

    @Column(name = "player6_points_away")
    @PositiveOrZero(message = "player6PointsAway must be greater than or equal to 0")
    private double player6PointsAway;

    @Column(name = "team1_score_overall")
    @PositiveOrZero(message = "team1ScoreOverall must be greater than or equal to 0")
    private int team1ScoreOverall;

    @Column(name = "team2_score_overall")
    @PositiveOrZero(message = "team2ScoreOverall must be greater than or equal to 0")
    private int team2ScoreOverall;

    @Column(name = "team1_points_overall")
    @PositiveOrZero(message = "team1PointsOverall must be greater than or equal to 0")
    private double team1PointsOverall;

    @Column(name = "team2_points_overall")
    @PositiveOrZero(message = "team2PointsOverall must be greater than or equal to 0")
    private double team2PointsOverall;
}
