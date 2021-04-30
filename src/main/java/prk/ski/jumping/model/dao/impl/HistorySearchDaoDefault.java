package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtils;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.query.HistorySearchQuery;
import prk.ski.jumping.model.domain.HistorySearch;

import java.sql.*;
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
        return Optional.empty();
    }

    @Override
    public List<HistorySearch> getAll() throws DataBaseException {
        return null;
    }

    @Override
    public void update(HistorySearch historySearch) throws DataBaseException {

    }

    @Override
    public void delete(long id) throws DataBaseException {

    }
}
