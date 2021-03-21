package prk.ski.jumping.model.domain;

import java.util.Objects;

public class Jumper {
    private long id;
    private String name;
    private String surname;
    private String origin;
    private double firstDistance;
    private double firstPoints;
    private double secondDistance;
    private double secondPoints;
    private double totalPoints;

    public Jumper(long id, String name, String surname, String origin, double firstDistance, double firstPoints,
                  double secondDistance, double secondPoints, double totalPoints) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.origin = origin;
        this.firstDistance = firstDistance;
        this.firstPoints = firstPoints;
        this.secondDistance = secondDistance;
        this.secondPoints = secondPoints;
        this.totalPoints = totalPoints;
    }

    // getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOrigin() {
        return origin;
    }

    public double getFirstDistance() {
        return firstDistance;
    }

    public double getFirstPoints() {
        return firstPoints;
    }

    public double getSecondDistance() {
        return secondDistance;
    }

    public double getSecondPoints() {
        return secondPoints;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

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

    public void setFirstDistance(double distance) {
        this.firstDistance = distance;
    }

    public void setFirstPoints(double points) {
        this.firstPoints = points;
    }

    public void setSecondDistance(double distance) {
        this.secondDistance = distance;
    }

    public void setSecondPoints(double points) {
        this.secondPoints = points;
    }

    public void setTotalPoints(double points) {
        this.totalPoints = points;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        Jumper jumper = (Jumper) other;

        return id == jumper.id && name == jumper.name && surname == jumper.surname && origin == jumper.origin
                && firstDistance == jumper.firstDistance && firstPoints == jumper.firstPoints
                && secondDistance == jumper.secondDistance && secondPoints == jumper.secondPoints
                && totalPoints == jumper.totalPoints;
    }

    public int hashCode() {
        return (int) Objects.hash(name, surname, origin, firstDistance, firstPoints, secondDistance, secondPoints,
                totalPoints);
    }

    public String toString() {
        String jumper = "Jumper {" + "id = " + id + ",name = " + name + ",surname = " + surname + ",origin = " + origin
                + ",firstJumpDistance = " + firstDistance + ",firstPoints = " + firstPoints + ",secondDistance = "
                + secondDistance + ",secondPoints = " + secondPoints + ",totalPoints = " + totalPoints + "}";
        return jumper;
    }
}
