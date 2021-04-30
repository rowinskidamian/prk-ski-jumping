package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtils;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.query.HistorySearchQuery;
import prk.ski.jumping.model.domain.HistorySearch;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class HistorySearchDaoDefault implements HistorySearchDao {


    @Override
    public HistorySearch create(HistorySearch historySearch) throws DataBaseException {
        try (Connection connection = DbUtils.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(
                     HistorySearchQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, historySearch.getSearchName());
            Date hsDate = Date.valueOf(historySearch.getSearchDate());
            ps.setDate(2, hsDate);
            ps.setString(3, historySearch.getSearchType());
            ps.setInt(4, historySearch.getTournamentAmount());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    historySearch.setId(id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
        }
        return historySearch;
    }

    @Override
    public Optional<HistorySearch> getById(long id) throws DataBaseException {
        HistorySearch hs = null;

        try (Connection con = DbUtils.connectToDatabase();
             PreparedStatement ps = con.prepareStatement(HistorySearchQuery.READ.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hs = new HistorySearch();
                    hs.setSearchName(rs.getString("search_name"));
                    Date searchDate = rs.getDate("search_date");
                    LocalDate searchLocalDate = searchDate.toLocalDate();
                    hs.setSearchDate(searchLocalDate);
                    hs.setSearchType(rs.getString("search_type"));
                    hs.setTournamentAmount(rs.getInt("tournament_amount"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekrodu z bazy danych.");
        }
        return Optional.ofNullable(hs);
    }

    @Override
    public List<HistorySearch> getAll() throws DataBaseException {
        List<HistorySearch> hsList = new ArrayList<>();

        try (Connection con = DbUtils.connectToDatabase();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(HistorySearchQuery.GET_ALL.getSqlQuery())) {

            while (rs.next()) {
                HistorySearch hs = new HistorySearch();
                hs.setId(rs.getLong("hs_id"));
                hs.setSearchName(rs.getString("search_name"));
                Date searchDate = rs.getDate("search_date");
                LocalDate searchLocalDate = searchDate.toLocalDate();
                hs.setSearchDate(searchLocalDate);
                hs.setSearchType(rs.getString("search_type"));
                hs.setTournamentAmount(rs.getInt("tournament_amount"));
                hsList.add(hs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać wszystkich rekordów z bazy.");
        }
        return hsList;
    }

    @Override
    public void update(HistorySearch historySearch) throws DataBaseException {
        try (PreparedStatement ps = DbUtils.connectToDatabase()
        .prepareStatement(HistorySearchQuery.UPDATE.getSqlQuery())) {

            ps.setString(1, historySearch.getSearchName());
            Date hsDate = Date.valueOf(historySearch.getSearchDate());
            ps.setDate(2, hsDate);
            ps.setString(3, historySearch.getSearchType());
            ps.setInt(4, historySearch.getTournamentAmount());
            ps.setLong(5, historySearch.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas aktualizowania danych w bazie");
        }

    }

    @Override
    public void delete(long id) throws DataBaseException {
        try (PreparedStatement ps = DbUtils.connectToDatabase()
        .prepareStatement(HistorySearchQuery.DELETE.getSqlQuery())) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Problem podczas usuwania rekordu z bazy danych");
        }

    }
}
