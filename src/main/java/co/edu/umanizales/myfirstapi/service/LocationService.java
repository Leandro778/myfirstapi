package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Getter
public class LocationService {

    private List<Location> locations;
    private List<Location> departments;
    private Set<String> seenDepartmentsCodes;

    @Value("${locations_filename}")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();
        departments = new ArrayList<>();
        seenDepartmentsCodes = new HashSet<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2], line[3]));

                if (!seenDepartmentsCodes.contains(line[0])) {
                    departments.add(new Location(line[0], line[1]));
                    seenDepartmentsCodes.add(line[0]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationsByName(String name) {
        List<Location> results = new ArrayList<>();
        for (Location location : locations) {
            if (location.getMunicipality().equalsIgnoreCase(name)) {
                results.add(location);
            }
        }
        return results;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : departments) {
            if (location.getCode().length() == 2) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getDepartmentByInitial(char initial) {
        List<Location> filtered = new ArrayList<>();
        for (Location Department : departments) {
            Location department = null;
            if (!department.getMunicipality().isEmpty() &&
                    Character.toUpperCase(department.getMunicipality().charAt(0)) == Character.toUpperCase(initial)) {
                filtered.add(department);
                {
                }
            }
        }
        return filtered;
    }
    //get Capitals
    public List<Location> getCapitals() {
        List<Location> capitals = new ArrayList<>();

        for (Location location : locations) {
            for (Location department : departments) {
                if (location.getCode().startsWith(department.getCode()) &&
                        location.getCode().endsWith("001")) {
                    capitals.add(location);
                    break; // Ya encontramos la capital para este departamento
                }
            }
        }

        return capitals;
    }

    public List<Location> getDepartmentsWithCapitals() {
        List<Location> result = new ArrayList<>();

        for (Location department : departments) {
            result.add(department);


            for (Location location : locations) {
                if (location.getCode().startsWith(department.getCode()) &&
                        location.getCode().endsWith("001")) {
                    result.add(location);
                    break;
                }
            }
        }

        return result;
    }

}
