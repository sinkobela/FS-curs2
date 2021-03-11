package ro.fasttrackit.curs2;

import ro.fasttrackit.curs2.countries.Continent;
import ro.fasttrackit.curs2.countries.Country;
import ro.fasttrackit.curs2.countries.FileCountryReportGenerator;
import ro.fasttrackit.curs2.countries.InMemoryCountryReportGenerator;
import ro.fasttrackit.curs2.countries.composition.InMemoryCountryProvider;
import ro.fasttrackit.curs2.countries.composition.ReportGenerator;
import ro.fasttrackit.curs2.interfaces.Pet;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(Pet.NAME);

        var generator = new FileCountryReportGenerator("C:\\fasttrackit\\fullstack\\curs2\\src\\main\\resources\\countries.txt");
        generator.generateReport("output.txt");

        new InMemoryCountryReportGenerator().generateReport("romania.txt");
        InMemoryCountryProvider provider = new InMemoryCountryProvider();

        new ReportGenerator(provider).generateReport("moldova.txt");
    }

    private static List<Country> provideCountries() {
        return List.of(new Country("Hungary", "Budapest", 98555, 1500000, Continent.EUROPE, List.of("ROU")));
    }
}
