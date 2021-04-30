package prk.ski.jumping.model.dao.query;

public enum TournamentIdListQuery {
    CREATE ("INSERT INTO tournament_id_list (search_id, tournament_id) values (?,?) "),
    READ ("SELECT * FROM tournament_id_list WHERE til_id = ?"),
    READ_BY_HISTORY_SEARCH("SELECT * FROM tournament_id_list WHERE search_id =?");

    private String sqlQuery;

    TournamentIdListQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

}
