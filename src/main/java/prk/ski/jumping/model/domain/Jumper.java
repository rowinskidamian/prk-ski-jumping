package prk.ski.jumping.model.domain;

import java.util.Objects;

public class Jumper {
    private long id;
    private String name;
    private String surname;
    private String origin;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;
    private double totalPoints;
    private long idHistory;

    public Jumper(long id, String name, String surname, String origin, int goldMedals, int silverMedals, int bronzeMedals, double totalPoints, long idHistory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.origin = origin;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
        this.totalPoints = totalPoints;
        this.idHistory = idHistory;
    }

    public Jumper() {
    }

    // getters
    public long getId() {
        return id;
    }

    public String getName() { return name; }

    public String getSurname() {
        return surname;
    }

    public String getOrigin() {
        return origin;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public int getSilverMedals() { return silverMedals; }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public long getIdHistory() { return idHistory; }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOrigin(String country) {
        this.origin = country;
    }

    public void setGoldMedals(int amount) {
        this.goldMedals = amount;
    }

    public void setSilverMedals(int amount) { this.silverMedals = amount; }

    public void setBronzeMedals(int amount) {
        this.bronzeMedals = amount;
    }

    public void setTotalPoints(double points) {
        this.totalPoints = points;
    }

    public void setIdHistory(long idHistory) { this.idHistory = idHistory; }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        Jumper jumper = (Jumper) other;

        return id == jumper.id && name == jumper.name && surname == jumper.surname && origin == jumper.origin
                && goldMedals == jumper.goldMedals && silverMedals == jumper.silverMedals
                && bronzeMedals == jumper.bronzeMedals && totalPoints == jumper.totalPoints
                && idHistory == jumper.idHistory;
    }

    public int hashCode() {
        return (int) Objects.hash(name, surname, origin, goldMedals, silverMedals, bronzeMedals, totalPoints, idHistory);
    }

    public String toString() {
        String jumper = "Jumper {id = " + id + ",name = " + name + ",surname = " + surname + ",origin = " + origin
                + ",goldMedals = " + goldMedals + ",silverMedals = " + silverMedals + ",bronzeMedals = "
                + bronzeMedals + ",totalPoints = " + totalPoints +  ",idHistory = " + idHistory + "}";
        return jumper;
    }
}
