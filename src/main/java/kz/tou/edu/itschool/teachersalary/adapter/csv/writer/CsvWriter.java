package kz.tou.edu.itschool.teachersalary.adapter.csv.writer;

import com.opencsv.bean.HeaderColumnNameMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CsvWriter {

    public static <T> void write(Path path, List<T> beans, Class<T> clazz) {
        try(var fileWriter = new FileWriter(path.toFile())) {
            var strategy = new HeaderColumnNameMappingStrategyBuilder<T>().build();
            strategy.setType(clazz);

            var beanToCsv = new StatefulBeanToCsvBuilder<T>(fileWriter).
                    withSeparator(';').
                    withMappingStrategy(strategy).
                    build();
            beanToCsv.write(beans);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}
