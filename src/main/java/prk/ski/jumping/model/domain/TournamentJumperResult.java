package prk.ski.jumping.model.domain;

import java.util.Objects;

public class TournamentJumperResult {

    private long id;
    private int rank;
    private String athleteName;
    private double distanceFirst;
    private double pointsFirst;
    private double distanceSecond;
    private double pointsSecond;
    private double totalPoints;
    private long tournamentId;

    public TournamentJumperResult() {
    }

    public TournamentJumperResult(long id, int rank, String athleteName, double distanceFirst,
                                  double pointsFirst, double distanceSecond, double pointsSecond, double totalPoints,
                                  long tournamentId) {
        this.id = id;
        this.rank = rank;
        this.athleteName = athleteName;
        this.distanceFirst = distanceFirst;
        this.pointsFirst = pointsFirst;
        this.distanceSecond = distanceSecond;
        this.pointsSecond = pointsSecond;
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

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public double getDistanceFirst() {
        return distanceFirst;
    }

    public void setDistanceFirst(double distanceFirst) {
        this.distanceFirst = distanceFirst;
    }

    public double getPointsFirst() {
        return pointsFirst;
    }

    public void setPointsFirst(double pointsFirst) {
        this.pointsFirst = pointsFirst;
    }

    public double getDistanceSecond() {
        return distanceSecond;
    }

    public void setDistanceSecond(double distanceSecond) {
        this.distanceSecond = distanceSecond;
    }

    public double getPointsSecond() {
        return pointsSecond;
    }

    public void setPointsSecond(double pointsSecond) {
        this.pointsSecond = pointsSecond;
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
        return id == that.id &&
                rank == that.rank &&
                Double.compare(that.distanceFirst, distanceFirst) == 0 &&
                Double.compare(that.pointsFirst, pointsFirst) == 0 &&
                Double.compare(that.distanceSecond, distanceSecond) == 0 &&
                Double.compare(that.pointsSecond, pointsSecond) == 0 &&
                Double.compare(that.totalPoints, totalPoints) == 0 &&
                tournamentId == that.tournamentId &&
                Objects.equals(athleteName, that.athleteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, athleteName, distanceFirst, pointsFirst, distanceSecond, pointsSecond,
                totalPoints, tournamentId);
    }

    @Override
    public String toString() {
        return "TournamentJumperResult{" +
                "id=" + id +
                ", rank=" + rank +
                ", athleteName='" + athleteName + '\'' +
                ", distanceFirst=" + distanceFirst +
                ", pointsFirst=" + pointsFirst +
                ", distanceSecond=" + distanceSecond +
                ", pointsSecond=" + pointsSecond +
                ", totalPoints=" + totalPoints +
                ", tournamentId=" + tournamentId +
                '}';
    }
}
