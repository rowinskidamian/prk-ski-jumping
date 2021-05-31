package prk.ski.jumping.model.dao;

import prk.ski.jumping.exception.DataBaseException;

/**
 * @author DamianRowinski
 */

public interface DBOperationsDao {
    int getTotalJumperResultsNumber() throws DataBaseException;
    int getTotalTournamentNumber() throws DataBaseException;
    void cleanDatabase() throws DataBaseException;
}
