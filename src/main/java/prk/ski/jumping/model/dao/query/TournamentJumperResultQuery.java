package prk.ski.jumping.model.dao.query;

/**
 * @author DamianRowinski
 */

public enum TournamentJumperResultQuery {

    CREATE ("insert into tournament_jumper_results (tjr_rank, origin, athlete_name, total_points, " +
            "tournament_world_cup_id) values (?,?,?,?,?)"),
    READ ("SELECT * FROM tournament_jumper_results where tjr_id = ?"),
    READ_BY_TOURNAMENT_ID("SELECT * FROM tournament_jumper_results where tournament_world_cup_id = ?"),
    UPDATE ("UPDATE tournament_jumper_results SET tjr_rank = ?, origin = ?, athlete_name = ?, total_points = ?," +
            "tournament_world_cup_id = ? where tjr_id = ?"),
    DELETE ("DELETE FROM tournament_jumper_results WHERE tjr_id = ?"),
    GET_ALL ("SELECT * FROM tournament_jumper_results");

    private final String sqlQuery;

    TournamentJumperResultQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

}
