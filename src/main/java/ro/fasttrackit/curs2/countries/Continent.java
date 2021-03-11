package ro.fasttrackit.curs2.countries;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Stream;

public enum Continent {
    EUROPE(true, 1234566),
    ASIA(true, 942597982),
    AMERICA(false, 892582),
    AFRICA(true, 82375823),
    AUSTRALIA(false, 925);

    private final boolean isNorthHemisphere;
    private final long area;

    Continent(boolean isNorthHemisphere, long area) {
        this.isNorthHemisphere = isNorthHemisphere;
        this.area = area;
    }

    public boolean isNorthHemisphere() {
        return isNorthHemisphere;
    }

    public long getArea() {
        return area;
    }

    public static Optional<Continent> of(String continentName) {
        return Stream.of(values())
                .filter(val -> val.name().equalsIgnoreCase(continentName))
                .findFirst();
    }
}
