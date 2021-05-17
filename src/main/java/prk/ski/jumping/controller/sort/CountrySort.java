package prk.ski.jumping.controller.sort;

import prk.ski.jumping.model.domain.Country;

import java.util.Comparator;

public class CountrySort implements Comparator<Country> {
    public int compare(Country a, Country b)
    {
        return (int) (b.getTotalPoints() -a.getTotalPoints());
    }
}
