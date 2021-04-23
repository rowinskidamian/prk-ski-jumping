package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtils;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.query.TournamentJumperResultQuery;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class TournamentJumperResultDaoDefault implements TournamentJumperResultDao {

    @Override
    public TournamentJumperResult create(TournamentJumperResult tjr) throws DataBaseException {
        try(Connection connection = DbUtils.connectToDatabase();
            PreparedStatement ps = connection.prepareStatement(
                    TournamentJumperResultQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, tjr.getRank());
            ps.setString(2, tjr.getOrigin());
            ps.setString(3, tjr.getAthleteName());
            ps.setDouble(4, tjr.getTotalPoints());
            ps.setLong(5, tjr.getTournamentId());
            ps.executeUpdate();

            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if(resultSet.next()) {
                    long id = resultSet.getLong(1);
                    tjr.setId(id);
                    return tjr;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<TournamentJumperResult> getAll() {
        return null;
    }

    @Override
    public void update(TournamentJumperResult tjr, long id) {

    }

    @Override
    public void delete(TournamentJumperResult tjr, long id) {

    }
}
