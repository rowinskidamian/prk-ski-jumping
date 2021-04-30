package prk.ski.jumping.model.dao.query;

public enum HistorySearchQuery {

    CREATE ("INSERT INTO history_search (search_name, search_date, search_type, tournament_amount) " +
            "values (?,?,?,?)"),
    READ ("SELECT * FROM history_search WHERE hs_id = ?"),
    UPDATE ("UPDATE history_search SET search_name = ?, search_date = ?, search_type = ?, tournament_amount = ?"),
    DELETE ("DELETE FROM history_search WHERE hs_id = ?"),
    GET_ALL ("SELECT * FROM history_search");

    private String sqlQuery;

    HistorySearchQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }
}
