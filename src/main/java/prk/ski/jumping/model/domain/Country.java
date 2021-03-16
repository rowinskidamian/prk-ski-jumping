package prk.ski.jumping.model.domain;

import java.util.Objects;

public class Country {
    private long id;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    public Country(long id, int goldMedals, int silverMedals, int bronzeMedals) {
        this.id = id;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    // getters
    public long getId() {
        return id;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    // setters
    public void setId(long id) {
        this.id = id;
    }

    public void setGoldMedals(int medals) {
        this.goldMedals = medals;
    }

    public void setSilverMedals(int medals) {
        this.silverMedals = medals;
    }

    public void setBronzeMedals(int medals) {
        this.bronzeMedals = medals;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        Country country = (Country) other;

        return id == country.id && goldMedals == country.goldMedals && silverMedals == country.silverMedals
                && bronzeMedals == country.bronzeMedals;
    }

    public int hashCode() {
        return (int) Objects.hash(id, goldMedals, silverMedals, bronzeMedals);
    }

    public String toString() {
        String country = "Country {" + "id = " + id + ", goldMedals = " + goldMedals + ", silverMedals = "
                + silverMedals + ", bronzeMedals = " + bronzeMedals + "}";
        return country;
    }
}
