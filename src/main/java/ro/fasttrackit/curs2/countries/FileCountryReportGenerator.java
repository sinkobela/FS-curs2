package ro.fasttrackit.curs2.countries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileCountryReportGenerator extends CountryReportGenerator {
    private final String sourceFile;

    public FileCountryReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    protected List<Country> readCountries() {
        try {
            Files.lines(Path.of(sourceFile))
                    .map(this::readCountry)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Couldn't read from file " + sourceFile);
        }
        return List.of();
    }

    private Country readCountry(String line) {
        String[] countryInfo = line.split("\\|");
        return new Country(
                countryInfo[0],
                countryInfo[1],
                Long.parseLong(countryInfo[3]),
                Long.parseLong(countryInfo[2]),
                Continent.of(countryInfo[4]).orElse(null),
                countryInfo.length > 5 ? parseNeighbours(countryInfo[5]) : List.of()
        );
    }

    private List<String> parseNeighbours(String neighbours) {
        if (neighbours != null) {
            return Arrays.stream(neighbours.split("~"))
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}
