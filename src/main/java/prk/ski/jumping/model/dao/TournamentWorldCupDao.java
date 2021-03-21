package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;

public interface TournamentWorldCupDao {

    public void create(TournamentWorldCup twc);
    public List<TournamentWorldCup> getAll();
}
