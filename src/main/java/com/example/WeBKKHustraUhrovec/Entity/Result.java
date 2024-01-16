package com.example.WeBKKHustraUhrovec.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public Player getPlayer1Home() {
        return player1Home;
    }

    public void setPlayer1Home(Player player1Home) {
        this.player1Home = player1Home;
    }

    public Player getPlayer2Home() {
        return player2Home;
    }

    public void setPlayer2Home(Player player2Home) {
        this.player2Home = player2Home;
    }

    public Player getPlayer3Home() {
        return player3Home;
    }

    public void setPlayer3Home(Player player3Home) {
        this.player3Home = player3Home;
    }

    public Player getPlayer4Home() {
        return player4Home;
    }

    public void setPlayer4Home(Player player4Home) {
        this.player4Home = player4Home;
    }

    public Player getPlayer5Home() {
        return player5Home;
    }

    public void setPlayer5Home(Player player5Home) {
        this.player5Home = player5Home;
    }

    public Player getPlayer6Home() {
        return player6Home;
    }

    public void setPlayer6Home(Player player6Home) {
        this.player6Home = player6Home;
    }

    public int getPlayer1ScoreHome() {
        return player1ScoreHome;
    }

    public void setPlayer1ScoreHome(int player1ScoreHome) {
        this.player1ScoreHome = player1ScoreHome;
    }

    public double getPlayer1PointsHome() {
        return player1PointsHome;
    }

    public void setPlayer1PointsHome(double player1PointsHome) {
        this.player1PointsHome = player1PointsHome;
    }

    public int getPlayer2ScoreHome() {
        return player2ScoreHome;
    }

    public void setPlayer2ScoreHome(int player2ScoreHome) {
        this.player2ScoreHome = player2ScoreHome;
    }

    public double getPlayer2PointsHome() {
        return player2PointsHome;
    }

    public void setPlayer2PointsHome(double player2PointsHome) {
        this.player2PointsHome = player2PointsHome;
    }

    public int getPlayer3ScoreHome() {
        return player3ScoreHome;
    }

    public void setPlayer3ScoreHome(int player3ScoreHome) {
        this.player3ScoreHome = player3ScoreHome;
    }

    public double getPlayer3PointsHome() {
        return player3PointsHome;
    }

    public void setPlayer3PointsHome(double player3PointsHome) {
        this.player3PointsHome = player3PointsHome;
    }

    public int getPlayer4ScoreHome() {
        return player4ScoreHome;
    }

    public void setPlayer4ScoreHome(int player4ScoreHome) {
        this.player4ScoreHome = player4ScoreHome;
    }

    public double getPlayer4PointsHome() {
        return player4PointsHome;
    }

    public void setPlayer4PointsHome(double player4PointsHome) {
        this.player4PointsHome = player4PointsHome;
    }

    public int getPlayer5ScoreHome() {
        return player5ScoreHome;
    }

    public void setPlayer5ScoreHome(int player5ScoreHome) {
        this.player5ScoreHome = player5ScoreHome;
    }

    public double getPlayer5PointsHome() {
        return player5PointsHome;
    }

    public void setPlayer5PointsHome(double player5PointsHome) {
        this.player5PointsHome = player5PointsHome;
    }

    public int getPlayer6ScoreHome() {
        return player6ScoreHome;
    }

    public void setPlayer6ScoreHome(int player6ScoreHome) {
        this.player6ScoreHome = player6ScoreHome;
    }

    public double getPlayer6PointsHome() {
        return player6PointsHome;
    }

    public void setPlayer6PointsHome(double player6PointsHome) {
        this.player6PointsHome = player6PointsHome;
    }

    public Player getPlayer1Away() {
        return player1Away;
    }

    public void setPlayer1Away(Player player1Away) {
        this.player1Away = player1Away;
    }

    public Player getPlayer2Away() {
        return player2Away;
    }

    public void setPlayer2Away(Player player2Away) {
        this.player2Away = player2Away;
    }

    public Player getPlayer3Away() {
        return player3Away;
    }

    public void setPlayer3Away(Player player3Away) {
        this.player3Away = player3Away;
    }

    public Player getPlayer4Away() {
        return player4Away;
    }

    public void setPlayer4Away(Player player4Away) {
        this.player4Away = player4Away;
    }

    public Player getPlayer5Away() {
        return player5Away;
    }

    public void setPlayer5Away(Player player5Away) {
        this.player5Away = player5Away;
    }

    public Player getPlayer6Away() {
        return player6Away;
    }

    public void setPlayer6Away(Player player6Away) {
        this.player6Away = player6Away;
    }

    public int getPlayer1ScoreAway() {
        return player1ScoreAway;
    }

    public void setPlayer1ScoreAway(int player1ScoreAway) {
        this.player1ScoreAway = player1ScoreAway;
    }

    public double getPlayer1PointsAway() {
        return player1PointsAway;
    }

    public void setPlayer1PointsAway(double player1PointsAway) {
        this.player1PointsAway = player1PointsAway;
    }

    public int getPlayer2ScoreAway() {
        return player2ScoreAway;
    }

    public void setPlayer2ScoreAway(int player2ScoreAway) {
        this.player2ScoreAway = player2ScoreAway;
    }

    public double getPlayer2PointsAway() {
        return player2PointsAway;
    }

    public void setPlayer2PointsAway(double player2PointsAway) {
        this.player2PointsAway = player2PointsAway;
    }

    public int getPlayer3ScoreAway() {
        return player3ScoreAway;
    }

    public void setPlayer3ScoreAway(int player3ScoreAway) {
        this.player3ScoreAway = player3ScoreAway;
    }

    public double getPlayer3PointsAway() {
        return player3PointsAway;
    }

    public void setPlayer3PointsAway(double player3PointsAway) {
        this.player3PointsAway = player3PointsAway;
    }

    public int getPlayer4ScoreAway() {
        return player4ScoreAway;
    }

    public void setPlayer4ScoreAway(int player4ScoreAway) {
        this.player4ScoreAway = player4ScoreAway;
    }

    public double getPlayer4PointsAway() {
        return player4PointsAway;
    }

    public void setPlayer4PointsAway(double player4PointsAway) {
        this.player4PointsAway = player4PointsAway;
    }

    public int getPlayer5ScoreAway() {
        return player5ScoreAway;
    }

    public void setPlayer5ScoreAway(int player5ScoreAway) {
        this.player5ScoreAway = player5ScoreAway;
    }

    public double getPlayer5PointsAway() {
        return player5PointsAway;
    }

    public void setPlayer5PointsAway(double player5PointsAway) {
        this.player5PointsAway = player5PointsAway;
    }

    public int getPlayer6ScoreAway() {
        return player6ScoreAway;
    }

    public void setPlayer6ScoreAway(int player6ScoreAway) {
        this.player6ScoreAway = player6ScoreAway;
    }

    public double getPlayer6PointsAway() {
        return player6PointsAway;
    }

    public void setPlayer6PointsAway(double player6PointsAway) {
        this.player6PointsAway = player6PointsAway;
    }

    public int getTeam1ScoreOverall() {
        return team1ScoreOverall;
    }

    public void setTeam1ScoreOverall(int team1ScoreOverall) {
        this.team1ScoreOverall = team1ScoreOverall;
    }

    public int getTeam2ScoreOverall() {
        return team2ScoreOverall;
    }

    public void setTeam2ScoreOverall(int team2ScoreOverall) {
        this.team2ScoreOverall = team2ScoreOverall;
    }

    public double getTeam1PointsOverall() {
        return team1PointsOverall;
    }

    public void setTeam1PointsOverall(double team1PointsOverall) {
        this.team1PointsOverall = team1PointsOverall;
    }

    public double getTeam2PointsOverall() {
        return team2PointsOverall;
    }

    public void setTeam2PointsOverall(double team2PointsOverall) {
        this.team2PointsOverall = team2PointsOverall;
    }

    public Result() {
    }
}
