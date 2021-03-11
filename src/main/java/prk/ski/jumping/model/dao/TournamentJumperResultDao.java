package main.java.prk.ski.jumping.model.dao;

import main.java.prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.List;
import java.util.Optional;

public interface TournamentJumperResultDao {

    public void create(TournamentJumperResult tournamentJumperResult);
    public Optional<TournamentJumperResult> getById(long id);
    public List<TournamentJumperResult> getAll();
    public void update(TournamentJumperResult tjr, long id);
    public void delete(TournamentJumperResult tjr, long id);

}
