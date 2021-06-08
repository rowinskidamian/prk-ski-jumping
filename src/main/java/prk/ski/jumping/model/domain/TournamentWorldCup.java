package prk.ski.jumping.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author RadosławParol
 */

public class TournamentWorldCup {
    private long id;
    private LocalDate date;
    private String place;
    private String gender;
    private String link;

    public TournamentWorldCup(long id, LocalDate date, String place, String gender, String link) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.gender = gender;
        this.link = link;
    }

    public TournamentWorldCup() {

    }

    // getters
    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getGender() {
        return gender;
    }

    public String getLink() {
        return link;
    }

    // setters
    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;

        TournamentWorldCup tournament = (TournamentWorldCup) other;

        return id == tournament.id && date == tournament.date && place == tournament.place
                && gender == tournament.gender && link == tournament.link;
    }

    public int hashCode() {
        return Objects.hash(id, date, place, gender, link);
    }

    public String toString() {
        String jumper = "TournamentWorldCup {" + "id = " + id + ",date = " + date + ",place = " + place + ",gender = "
                + gender + ",link = " + link + "}";
        return jumper;
    }
}
