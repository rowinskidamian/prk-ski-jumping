package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtilities;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.DBOperationsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author DamianRowinski
 */

public class DBOperationsDaoDefault implements DBOperationsDao {

    @Override
    public int getTotalJumperResultsNumber() throws DataBaseException {
        int totalResults = 0;
        String sqlQuery = "SELECT COUNT(*) FROM tournament_jumper_results";
        try (Connection cn = DbUtilities.connectToDatabase();
             Statement statement = cn.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            totalResults = resultSet.getInt(1);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas pobierania wszystkich wyników skoczków.");
        }

        return totalResults;
    }

    @Override
    public int getTotalTournamentNumber() throws DataBaseException {
        int totalTournamentNumber = 0;
        String sqlQuery = "SELECT COUNT(*) FROM tournament_world_cup;";
        try (Connection cn = DbUtilities.connectToDatabase();
             Statement statement = cn.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            totalTournamentNumber = resultSet.getInt(1);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas pobierania liczby turniejów zapisanych w bazie danych.");
        }

        return totalTournamentNumber;
    }

    @Override
    public void cleanDatabase() throws DataBaseException {
        List<String> deleteStatements = List.of("DELETE FROM athlete_country_list",
        "DELETE FROM tournament_id_list",
        "DELETE FROM tournament_jumper_results",
        "DELETE FROM tournament_world_cup",
        "DELETE FROM history_search");

        try (Connection cn = DbUtilities.connectToDatabase();
        Statement statement = cn.createStatement()) {
            for (String deleteStatement : deleteStatements) {
                statement.execute(deleteStatement);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw new DataBaseException("Błąd podczas usuwania danych z bazy.");
        }
    }
}
