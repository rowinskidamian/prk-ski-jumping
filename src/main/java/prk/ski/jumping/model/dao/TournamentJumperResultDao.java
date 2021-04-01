package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public interface TournamentJumperResultDao {

    void create(TournamentJumperResult tournamentJumperResult);
    Optional<TournamentJumperResult> getById(long id);
    List<TournamentJumperResult> getAll();
    void update(TournamentJumperResult tjr, long id);
    void delete(TournamentJumperResult tjr, long id);

}
