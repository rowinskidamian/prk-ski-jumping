package prk.ski.jumping.model.dao.query;

/**
 * @author DamianRowinski
 */

public enum AthleteCountryListQuery {

    CREATE("INSERT INTO athlete_country_list (search_id, name) values (?,?) "),
    READ("SELECT * FROM athlete_country_list WHERE acl_id = ?"),
    READ_BY_HISTORY_SEARCH("SELECT * FROM athlete_country_list WHERE search_id = ?");

    private String sqlQuery;

    AthleteCountryListQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }
}
