package packt.mastering.java9.process.daemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Parameters {

    final String[] commandLine;

    public Parameters(String[] commandLine) {
        this.commandLine = commandLine;
    }

    private static String[] getCL(Properties props) {
        return Optional
                .ofNullable(props.getProperty("commandLine"))
                .orElse("")
                .split("\\s+");
    }

    public static Parameters fromFile(final File file) {
        final Properties props = new Properties();
        try (final InputStream is = new FileInputStream(file)) {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Parameters(getCL(props));
    }
}
