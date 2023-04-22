package kz.tou.edu.itschool.teachersalary.adapter.csv.reader;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CsvReader {

    public static <T> List<T> read(Path path, Class<T> clazz) {
        try(var ioReader = new FileReader(path.toFile())) {
            return new CsvToBeanBuilder<T>(ioReader).
                    withSkipLines(1).
                    withType(clazz).
                    withSeparator(';').
                    build().
                    parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
