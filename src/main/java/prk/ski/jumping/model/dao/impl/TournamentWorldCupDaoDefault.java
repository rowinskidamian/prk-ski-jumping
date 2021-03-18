package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.domain.TournamentWorldCup;
import prk.ski.jumping.model.domain.TournamentWorldCupDB;

import java.util.List;
import java.util.Optional;

public class TournamentWorldCupDaoDefault implements TournamentWorldCupDao {
    private TournamentWorldCupDB tournamentWorldCupDB;

    public TournamentWorldCupDaoDefault() {
        tournamentWorldCupDB = new TournamentWorldCupDB();
    }

    @Override
    public void create(TournamentWorldCup tournamentWorldCupResult) { tournamentWorldCupDB.create(tournamentWorldCupResult); }
    @Override
    public Optional<TournamentWorldCup> getById(long id) { return tournamentWorldCupDB.getById(id); }
    @Override
    public List<TournamentWorldCup> getAll() { return tournamentWorldCupDB.getAll();}
    @Override
    public void update(TournamentWorldCup twc, long id) { tournamentWorldCupDB.update(twc, id);}
    @Override
    public void delete(TournamentWorldCup twc, long id) { tournamentWorldCupDB.delete(twc, id);}


}
