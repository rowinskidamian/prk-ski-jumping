package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;
import java.util.Optional;

public interface TournamentWorldCupDao {
    public void create(TournamentWorldCup cup);
    public Optional<TournamentWorldCup> getById(long id);
    public List<TournamentWorldCup> getAll();
    public void update(TournamentWorldCup twc, long id);
    public void delete(TournamentWorldCup twc, long id);

}
