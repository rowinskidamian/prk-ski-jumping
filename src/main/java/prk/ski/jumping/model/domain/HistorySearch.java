package prk.ski.jumping.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HistorySearch {

    private long id;
    private String searchName;
    private LocalDate searchDate;
    private String searchType;
    private int tournamentAmount;

    public HistorySearch() {
    }

    public HistorySearch(long id, String searchName, LocalDate searchDate, String searchType, int tournamentAmount) {
        this.id = id;
        this.searchName = searchName;
        this.searchDate = searchDate;
        this.searchType = searchType;
        this.tournamentAmount = tournamentAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public LocalDate getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDate searchDate) {
        this.searchDate = searchDate;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public int getTournamentAmount() {
        return tournamentAmount;
    }

    public void setTournamentAmount(int tournamentAmount) {
        this.tournamentAmount = tournamentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorySearch history = (HistorySearch) o;
        return id == history.id &&
                tournamentAmount == history.tournamentAmount &&
                Objects.equals(searchName, history.searchName) &&
                Objects.equals(searchDate, history.searchDate) &&
                Objects.equals(searchType, history.searchType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, searchName, searchDate, searchType, tournamentAmount);
    }

    @Override
    public String toString() {
        return "HistorySearch{" +
                "id=" + id +
                ", searchName='" + searchName + '\'' +
                ", searchDate=" + searchDate +
                ", searchType='" + searchType + '\'' +
                ", tournamentAmount=" + tournamentAmount +
                '}';
    }
}
