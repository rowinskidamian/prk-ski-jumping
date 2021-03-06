package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtilities;
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
        try (Connection connection = DbUtilities.connectToDatabase();
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
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
        }
        return tjr;
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) throws DataBaseException {
        TournamentJumperResult tjr = null;

        try (Connection connection = DbUtilities.connectToDatabase();
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
    public List<TournamentJumperResult> getByTournamentId(long id) throws DataBaseException {
        List<TournamentJumperResult> tjrList = new ArrayList<>();

        try (Connection cn = DbUtilities.connectToDatabase();
        PreparedStatement ps = cn.prepareStatement(TournamentJumperResultQuery.READ_BY_TOURNAMENT_ID.getSqlQuery())) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TournamentJumperResult tjr = getTournamentFromResultSet(rs);
                    tjrList.add(tjr);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Błąd przy wczytywaniu danych z bazy");
        }
        return tjrList;
    }

    @Override
    public List<TournamentJumperResult> getAll() throws DataBaseException {
        List<TournamentJumperResult> tjrList = new ArrayList<>();

        try (Connection cn = DbUtilities.connectToDatabase();
             Statement statement = cn.createStatement();
             ResultSet rs = statement.executeQuery(TournamentJumperResultQuery.GET_ALL.getSqlQuery())) {

            while (rs.next()) {
                TournamentJumperResult tjr = getTournamentFromResultSet(rs);
                tjrList.add(tjr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać wszystkich rekordów z bazy");
        }
        return tjrList;
    }

    private TournamentJumperResult getTournamentFromResultSet(ResultSet rs) throws SQLException {
        TournamentJumperResult tjr = new TournamentJumperResult();
        tjr.setTournamentId(rs.getLong("tjr_id"));
        tjr.setRank(rs.getInt("tjr_rank"));
        tjr.setOrigin(rs.getString("origin"));
        tjr.setAthleteName(rs.getString("athlete_name"));
        tjr.setTotalPoints(rs.getDouble("total_points"));
        tjr.setTournamentId(rs.getLong("tournament_world_cup_id"));
        return tjr;
    }

    @Override
    public void update(TournamentJumperResult tjr) throws DataBaseException {
        try (PreparedStatement ps = DbUtilities.connectToDatabase()
                .prepareStatement(TournamentJumperResultQuery.UPDATE.getSqlQuery())) {
            ps.setInt(1, tjr.getRank());
            ps.setString(2, tjr.getOrigin());
            ps.setString(3, tjr.getAthleteName());
            ps.setDouble(4, tjr.getTotalPoints());
            ps.setLong(5, tjr.getTournamentId());
            ps.setLong(6, tjr.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas aktualizowania danych w bazie");
        }
    }

    @Override
    public void delete(long id) throws DataBaseException {
        try (PreparedStatement ps = DbUtilities.connectToDatabase()
                .prepareStatement(TournamentJumperResultQuery.DELETE.getSqlQuery())) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Problem podczas usuwania rekordu z bazy danych");
        }
    }
}
