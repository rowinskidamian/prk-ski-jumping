package prk.ski.jumping.model.domain.additional;

import java.util.Objects;

/**
 * @author DamianRowinski
 */

public class AthleteCountryList {

    private long id;
    private long searchId;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSearchId() {
        return searchId;
    }

    public void setSearchId(long searchId) {
        this.searchId = searchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthleteCountryList that = (AthleteCountryList) o;
        return id == that.id && searchId == that.searchId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, searchId, name);
    }

    @Override
    public String toString() {
        return "AthleteCountryList{" +
                "id=" + id +
                ", searchId=" + searchId +
                ", name='" + name + '\'' +
                '}';
    }
}
