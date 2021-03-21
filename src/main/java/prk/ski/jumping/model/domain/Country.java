package prk.ski.jumping.model.domain;

import java.util.Objects;

public class Country {
    private long id;
    private String name;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;
    private long idHistory;

    public Country(long id, String name, int goldMedals, int silverMedals, int bronzeMedals, long idHistory) {
        this.id = id;
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
        this.idHistory = idHistory;
    }

    // getters
    public long getId() {
        return id;
    }

    public String getName() { return name; }

    public int getGoldMedals() {
        return goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public long getIdHistory() { return idHistory; }

    // setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name; }

    public void setGoldMedals(int medals) {
        this.goldMedals = medals;
    }

    public void setSilverMedals(int medals) {
        this.silverMedals = medals;
    }

    public void setBronzeMedals(int medals) {
        this.bronzeMedals = medals;
    }

    public void setIdHistory(long id) { this.idHistory = idHistory; }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        Country country = (Country) other;

        return id == country.id && name == country.name && goldMedals == country.goldMedals && silverMedals == country.silverMedals
                && bronzeMedals == country.bronzeMedals && idHistory == country.idHistory;
    }

    public int hashCode() {
        return (int) Objects.hash(id, name, goldMedals, silverMedals, bronzeMedals, idHistory);
    }

    public String toString() {
        String country = "Country {" + "id = " + id + ", name = " + name + ", goldMedals = " + goldMedals + ", silverMedals = "
                + silverMedals + ", bronzeMedals = " + bronzeMedals + ", idHistory = " + idHistory + "}";
        return country;
    }
}
