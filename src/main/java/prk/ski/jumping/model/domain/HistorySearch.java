package prk.ski.jumping.model.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author DamianRowinski
 */

public class HistorySearch {

    private long id;
    private String searchName;
    private LocalDate searchDate;
    private String searchType;
    private int tournamentAmount;
    private List<Long> tournamentIdList;
    private List<String> athleteCountryList;

    public HistorySearch() {
    }

    public HistorySearch(long id, String searchName, LocalDate searchDate, String searchType, int tournamentAmount,
                         List<Long> tournamentIdList, List<String> athleteCountryList) {
        this.id = id;
        this.searchName = searchName;
        this.searchDate = searchDate;
        this.searchType = searchType;
        this.tournamentAmount = tournamentAmount;
        this.tournamentIdList = tournamentIdList;
        this.athleteCountryList = athleteCountryList;
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

    public List<Long> getTournamentIdList() {
        return tournamentIdList;
    }

    public void setTournamentIdList(List<Long> tournamentIdList) {
        this.tournamentIdList = tournamentIdList;
    }

    public List<String> getAthleteCountryList() {
        return athleteCountryList;
    }

    public void setAthleteCountryList(List<String> athleteCountryList) {
        this.athleteCountryList = athleteCountryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorySearch that = (HistorySearch) o;
        return id == that.id && tournamentAmount == that.tournamentAmount && Objects.equals(searchName, that.searchName) && Objects.equals(searchDate, that.searchDate) && Objects.equals(searchType, that.searchType) && Objects.equals(tournamentIdList, that.tournamentIdList) && Objects.equals(athleteCountryList, that.athleteCountryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, searchName, searchDate, searchType, tournamentAmount, tournamentIdList, athleteCountryList);
    }

    @Override
    public String toString() {
        return "HistorySearch{" +
                "id=" + id +
                ", searchName='" + searchName + '\'' +
                ", searchDate=" + searchDate +
                ", searchType='" + searchType + '\'' +
                ", tournamentAmount=" + tournamentAmount +
                ", tournamentIdList=" + tournamentIdList +
                ", athleteCountryList=" + athleteCountryList +
                '}';
    }
}
