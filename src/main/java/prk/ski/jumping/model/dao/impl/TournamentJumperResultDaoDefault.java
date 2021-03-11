package main.java.prk.ski.jumping.model.dao.impl;

import main.java.prk.ski.jumping.model.dao.TournamentJumperResultDao;
import main.java.prk.ski.jumping.model.domain.TournamentJumperResult;
import main.java.prk.ski.jumping.model.domain.TournamentJumperResultDB;

import java.util.List;
import java.util.Optional;

public class TournamentJumperResultDaoDefault implements TournamentJumperResultDao {

    private TournamentJumperResultDB tournamentJumperResultDB;

    public TournamentJumperResultDaoDefault() {
        this.tournamentJumperResultDB = new TournamentJumperResultDB();
    }

    @Override
    public void create(TournamentJumperResult tournamentJumperResult) {
        tournamentJumperResultDB.create(tournamentJumperResult);
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) {
        return tournamentJumperResultDB.getById(id);
    }

    @Override
    public List<TournamentJumperResult> getAll() {
        return tournamentJumperResultDB.getAll();
    }

    @Override
    public void update(TournamentJumperResult tjr, long id) {
        tournamentJumperResultDB.update(tjr, id);
    }

    @Override
    public void delete(TournamentJumperResult tjr, long id) {
        tournamentJumperResultDB.delete(tjr, id);
    }
}
