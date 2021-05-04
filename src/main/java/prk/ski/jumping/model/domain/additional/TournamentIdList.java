package prk.ski.jumping.model.domain.additional;

import java.util.Objects;

/**
 * @author DamianRowinski
 */

public class TournamentIdList {

    private long tilId;
    private long searchId;
    private long tournamentId;

    public long getTilId() {
        return tilId;
    }

    public void setTilId(long tilId) {
        this.tilId = tilId;
    }

    public long getSearchId() {
        return searchId;
    }

    public void setSearchId(long searchId) {
        this.searchId = searchId;
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
        TournamentIdList that = (TournamentIdList) o;
        return tilId == that.tilId && searchId == that.searchId && tournamentId == that.tournamentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tilId, searchId, tournamentId);
    }

    @Override
    public String toString() {
        return "TournamentIdList{" +
                "tilId=" + tilId +
                ", searchId=" + searchId +
                ", tournamentId=" + tournamentId +
                '}';
    }
}
