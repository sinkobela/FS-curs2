package ro.fasttrackit.curs2.countries;

import java.util.*;

public class Country {
    private final String name;
    private final String capital;
    private final long area;
    private final long population;
    private final List<String> neighbours;
    private final Continent continent;

    public Country(String name, String capital, long area, long population, Continent continent, List<String> neighbours) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
        this.neighbours = Optional.ofNullable(neighbours)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public List<String> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    public Continent getContinent() {
        return continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return area == country.area && population == country.population && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(neighbours, country.neighbours) && continent == country.continent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, area, population, neighbours, continent);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", neighbours=" + neighbours +
                ", continent=" + continent +
                '}';
    }
}
