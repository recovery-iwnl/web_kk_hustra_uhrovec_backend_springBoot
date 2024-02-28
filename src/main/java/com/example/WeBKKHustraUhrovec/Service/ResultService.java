package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResultService {

    Result addResultSimple(String teamIdHome, String teamIdAway, Result result);

    Optional<Result> getResult(String id);

    List<Result> getResultsByLeagueYear(String id);

    List<Result> getAllResults();

    List<Result> getResultsUhrovec();

    String deleteResult(Integer id);
}
