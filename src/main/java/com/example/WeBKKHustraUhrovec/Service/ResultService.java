package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResultService {

    Result addResult(String teamIdHome, String teamIdAway,
                     String player1IdHome, String player2IdHome, String player3IdHome, String player4IdHome, String player5IdHome, String player6IdHome,
                     String player1IdAway, String player2IdAway, String player3IdAway, String player4IdAway, String player5IdAway, String player6IdAway,
                     Result result);

    Result addResultSimple(String teamIdHome, String teamIdAway, Result result);

    Optional<Result> getResult(String id);

    List<Result> getAllResults();

    List<Result> getResultsUhrovec();

    String deleteResult(Integer id);

    Result updateResult(Result result);
}
