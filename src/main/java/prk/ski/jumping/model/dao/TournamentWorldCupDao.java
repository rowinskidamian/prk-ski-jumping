package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;
import java.util.Optional;

public interface TournamentWorldCupDao {
    public TournamentWorldCup create(TournamentWorldCup cup);
    public Optional<TournamentWorldCup> getById(long id);
    public List<TournamentWorldCup> getAll();
    public void update(TournamentWorldCup cup, long id);
    public void delete(TournamentWorldCup cup, long id);
}
