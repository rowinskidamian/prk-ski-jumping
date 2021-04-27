package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtils;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.query.TournamentJumperResultQuery;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class TournamentJumperResultDaoDefault implements TournamentJumperResultDao {

    @Override
    public TournamentJumperResult create(TournamentJumperResult tjr) throws DataBaseException {
        try (Connection connection = DbUtils.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(
                     TournamentJumperResultQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, tjr.getRank());
            ps.setString(2, tjr.getOrigin());
            ps.setString(3, tjr.getAthleteName());
            ps.setDouble(4, tjr.getTotalPoints());
            ps.setLong(5, tjr.getTournamentId());
            ps.executeUpdate();

            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    tjr.setId(id);
                    return tjr;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
        }

        throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) throws DataBaseException {
        TournamentJumperResult tjr = null;

        try (Connection connection = DbUtils.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(TournamentJumperResultQuery.READ.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tjr = new TournamentJumperResult();
                    tjr.setTournamentId(id);
                    tjr.setRank(rs.getInt("tjr_rank"));
                    tjr.setOrigin(rs.getString("origin"));
                    tjr.setAthleteName(rs.getString("athlete_name"));
                    tjr.setTotalPoints(rs.getDouble("total_points"));
                    tjr.setTournamentId(rs.getLong("tournament_world_cup_id"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekordu z bazy danych.");
        }
        return Optional.ofNullable(tjr);
    }

    @Override
    public List<TournamentJumperResult> getAll() throws DataBaseException {
        List<TournamentJumperResult> tjrList = new ArrayList<>();

        try (Connection cn = DbUtils.connectToDatabase();
             Statement statement = cn.createStatement();
             ResultSet rs = statement.executeQuery(TournamentJumperResultQuery.GET_ALL.getSqlQuery())) {

            while (rs.next()) {
                TournamentJumperResult tjr = new TournamentJumperResult();
                tjr.setTournamentId(rs.getLong("tjr_id"));
                tjr.setRank(rs.getInt("tjr_rank"));
                tjr.setOrigin(rs.getString("origin"));
                tjr.setAthleteName(rs.getString("athlete_name"));
                tjr.setTotalPoints(rs.getDouble("total_points"));
                tjr.setTournamentId(rs.getLong("tournament_world_cup_id"));
                tjrList.add(tjr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać wszystkich rekordów z bazy");
        }

        return tjrList;
    }

    @Override
    public void update(TournamentJumperResult tjr) throws DataBaseException {
        try (PreparedStatement ps = DbUtils.connectToDatabase()
                .prepareStatement(TournamentJumperResultQuery.UPDATE.getSqlQuery())) {

            ps.setInt(1, tjr.getRank());
            ps.setString(2, tjr.getOrigin());
            ps.setString(3, tjr.getAthleteName());
            ps.setDouble(4, tjr.getTotalPoints());
            ps.setLong(5, tjr.getTournamentId());

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas aktualizowania danych w bazie");
        }

    }

    @Override
    public void delete(long id) throws DataBaseException{
        try(PreparedStatement ps = DbUtils.connectToDatabase()
        .prepareStatement(TournamentJumperResultQuery.DELETE.getSqlQuery())) {
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Problem podczas usuwania rekordu z bazy danych");
        }

    }
}
