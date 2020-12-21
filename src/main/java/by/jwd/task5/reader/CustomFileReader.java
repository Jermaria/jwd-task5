package by.jwd.task5.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task5.validation.FileValidator;

public class CustomFileReader {
    
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILE_PATH = "resources/data/points_db";
    
    public Optional<List<String>> readStringsFromFile(String path) throws CustomReaderException {
        if (!FileValidator.isSourceValid(path)) {
            logger.log(Level.ERROR, "invalid path input", path);
            path = DEFAULT_FILE_PATH;
        }
        Optional<List<String>> stringsOptional = Optional.empty();
        List<String> strings;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            strings = stream.collect(Collectors.toList());
            stringsOptional = Optional.of(strings);
        } catch (IOException e) {
            logger.log(Level.ERROR, "error occurs while opening the file", path);
            throw new CustomReaderException(e);
        }
        return stringsOptional;       
    }
}
