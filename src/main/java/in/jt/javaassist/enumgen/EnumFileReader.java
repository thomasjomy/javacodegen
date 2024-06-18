package in.jt.javaassist.enumgen;

import com.opencsv.CSVReader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EnumFileReader {
    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }
}
