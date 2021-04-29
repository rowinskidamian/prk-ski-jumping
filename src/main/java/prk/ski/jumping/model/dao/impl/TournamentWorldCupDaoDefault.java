package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.controller.utils.DbUtilities;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.query.TournamentWorldCupQuery;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TournamentWorldCupDaoDefault implements TournamentWorldCupDao {

    @Override
    public TournamentWorldCup create(TournamentWorldCup twc) {
        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(
                     TournamentWorldCupQuery.CREATE.getSqlQuery(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, Date.valueOf(twc.getDate()));
            ps.setString(2, twc.getPlace());
            ps.setString(3, twc.getGender());
            ps.setString(4, twc.getLink());
            ps.executeUpdate();

            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    twc.setId(id);
                    return twc;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return twc;
    }

    @Override
    public Optional<TournamentWorldCup> getById(long id) {
        TournamentWorldCup twc = null;

        try (Connection connection = DbUtilities.connectToDatabase();
             PreparedStatement ps = connection.prepareStatement(TournamentWorldCupQuery.READ.getSqlQuery())) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    twc = new TournamentWorldCup();
                    twc.setDate((rs.getDate("date")).toLocalDate());
                    twc.setPlace(rs.getString("place"));
                    twc.setGender(rs.getString("gender"));
                    twc.setLink(rs.getString("link"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return Optional.ofNullable(twc);
    }
    @Override
    public List<TournamentWorldCup> getAll() {
        List<TournamentWorldCup> twcList = new ArrayList<>();

        try (Connection cn = DbUtilities.connectToDatabase();
             Statement statement = cn.createStatement();
             ResultSet rs = statement.executeQuery(TournamentWorldCupQuery.GET_ALL.getSqlQuery())) {

            while (rs.next()) {
                TournamentWorldCup twc = new TournamentWorldCup();
                twc.setDate((rs.getDate("date")).toLocalDate());
                twc.setPlace(rs.getString("place"));
                twc.setGender(rs.getString("gender"));
                twc.setLink(rs.getString("link"));

                twcList.add(twc);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return twcList;
    }
    @Override
    public void update(TournamentWorldCup twc, long id) {
        try (PreparedStatement ps = DbUtilities.connectToDatabase()
                .prepareStatement(TournamentWorldCupQuery.UPDATE.getSqlQuery())) {

            ps.setDate(1, Date.valueOf(twc.getDate()));
            ps.setString(2, twc.getPlace());
            ps.setString(3, twc.getGender());
            ps.setString(4, twc.getLink());


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void delete(TournamentWorldCup twc, long id) {
        try(PreparedStatement ps = DbUtilities.connectToDatabase()
                .prepareStatement(TournamentWorldCupQuery.DELETE.getSqlQuery())) {
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }


}
