package prk.ski.jumping.model.dao.impl.additional;

import prk.ski.jumping.controller.utils.DbUtilities;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.query.additional.TournamentIdListQuery;
import prk.ski.jumping.model.domain.additional.TournamentIdList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class TournamentIdListDao {

    public TournamentIdList create(TournamentIdList til) throws DataBaseException {
        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(
                     TournamentIdListQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, til.getSearchId());
            ps.setLong(2, til.getTournamentId());
            ps.executeUpdate();

            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    til.setTilId(id);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
        }
        return til;
    }

    public Optional<TournamentIdList> getById(long id) throws DataBaseException {
        TournamentIdList til = null;

        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(TournamentIdListQuery.READ.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    til = new TournamentIdList();
                    til.setTilId(rs.getLong("til_id"));
                    til.setSearchId(rs.getLong("search_id"));
                    til.setTournamentId(rs.getLong("tournament_id"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekordu z bazy danych.");
        }
        return Optional.ofNullable(til);
    }

    public List<TournamentIdList> getByHistorySearchId(long id) throws DataBaseException {
        List<TournamentIdList> tilList = new ArrayList<>();

        try (Connection con = DbUtilities.connectToDatabase();
             PreparedStatement ps = con.prepareStatement(TournamentIdListQuery.READ_BY_HISTORY_SEARCH.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TournamentIdList til = new TournamentIdList();
                    til.setTilId(rs.getLong("til_id"));
                    til.setSearchId(rs.getLong("search_id"));
                    til.setTournamentId(rs.getLong("tournament_id"));
                    tilList.add(til);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekordu z bazy danych.");
        }
        return tilList;
    }

}
