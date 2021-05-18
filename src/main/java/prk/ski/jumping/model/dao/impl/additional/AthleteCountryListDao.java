package prk.ski.jumping.model.dao.impl.additional;

import prk.ski.jumping.controller.utils.DbUtilities;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.query.additional.AthleteCountryListQuery;
import prk.ski.jumping.model.domain.additional.AthleteCountryList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class AthleteCountryListDao {

    public AthleteCountryList create(AthleteCountryList acl) throws DataBaseException {
        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(
                     AthleteCountryListQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, acl.getSearchId());
            ps.setString(2, acl.getName());
            ps.executeUpdate();

            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    acl.setId(id);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można dodać nowego rekordu do bazy danych.");
        }
        return acl;
    }

    public Optional<AthleteCountryList> getById(long id) throws DataBaseException {
        AthleteCountryList acl = null;

        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(AthleteCountryListQuery.READ.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    acl = new AthleteCountryList();
                    acl.setId(rs.getLong("acl_id"));
                    acl.setSearchId(rs.getLong("search_id"));
                    acl.setName(rs.getString("name"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekordu z bazy danych.");
        }
        return Optional.ofNullable(acl);
    }

    public List<AthleteCountryList> getByHistorySearchId(long id) throws DataBaseException {
        List<AthleteCountryList> aclList = new ArrayList<>();

        try (Connection con = DbUtilities.connectToDatabase();
             PreparedStatement ps = con.prepareStatement(AthleteCountryListQuery.READ_BY_HISTORY_SEARCH.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AthleteCountryList acl = new AthleteCountryList();
                    acl.setId(rs.getLong("acl_id"));
                    acl.setSearchId(rs.getLong("search_id"));
                    acl.setName(rs.getString("name"));
                    aclList.add(acl);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataBaseException("Nie można pobrać rekordu z bazy danych.");
        }
        return aclList;
    }
}
