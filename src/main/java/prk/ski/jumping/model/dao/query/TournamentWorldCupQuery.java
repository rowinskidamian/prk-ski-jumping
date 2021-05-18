package prk.ski.jumping.model.dao.query;

/**
 * @author RadosławParol
 */

public enum TournamentWorldCupQuery {
    CREATE ("insert into tournament_world_cup (date, place, gender, link) values (?,?,?,?)"),
    READ ("SELECT * FROM tournament_world_cup where id = ?"),
    UPDATE ("UPDATE tournament_world_cup SET date = ?, place = ?, gender = ?, link = ?, where id = ?"),
    DELETE ("DELETE FROM tournament_world_cup WHERE twc_id = ?"),
    GET_ALL ("SELECT * FROM tournament_world_cup");

    private String sqlQuery;

    TournamentWorldCupQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }
}
