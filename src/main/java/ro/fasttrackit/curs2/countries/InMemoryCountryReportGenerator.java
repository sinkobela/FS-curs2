package ro.fasttrackit.curs2.countries;

import java.util.List;

public class InMemoryCountryReportGenerator  extends  CountryReportGenerator {
    @Override
    protected List<Country> readCountries() {
        return List.of(
                new Country("Romania", "Bucharest", 244257, 19000000, Continent.EUROPE, List.of("Hungary", "Moldova")));
    }

}
