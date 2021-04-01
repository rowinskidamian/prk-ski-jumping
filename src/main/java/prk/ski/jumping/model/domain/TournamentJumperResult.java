package prk.ski.jumping.model.domain;

import java.util.Objects;

public class TournamentJumperResult {

    private long id;
    private int rank;
    private String origin;
    private String athleteName;
    private double totalPoints;
    private long tournamentId;

    public TournamentJumperResult() {
    }

    public TournamentJumperResult(long id, int rank, String origin, String athleteName, double totalPoints, long tournamentId) {
        this.id = id;
        this.rank = rank;
        this.origin = origin;
        this.athleteName = athleteName;
        this.totalPoints = totalPoints;
        this.tournamentId = tournamentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentJumperResult that = (TournamentJumperResult) o;
        return id == that.id && rank == that.rank && Double.compare(that.totalPoints, totalPoints) == 0
                && tournamentId == that.tournamentId && Objects.equals(origin, that.origin)
                && Objects.equals(athleteName, that.athleteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, origin, athleteName, totalPoints, tournamentId);
    }

    @Override
    public String toString() {
        return "TournamentJumperResult{" +
                "id=" + id +
                ", rank=" + rank +
                ", origin='" + origin + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", totalPoints=" + totalPoints +
                ", tournamentId=" + tournamentId +
                '}';
    }
}
