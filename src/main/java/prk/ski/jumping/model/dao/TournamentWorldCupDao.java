package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;

public interface TournamentWorldCupDao {
    public void create(TournamentWorldCup cup);

    public TournamentWorldCup getById(long id);

    public List<TournamentWorldCup> getAll();

    public void update(TournamentWorldCup cup, long id);

    public void delete(TournamentWorldCup cup, long id);

}
