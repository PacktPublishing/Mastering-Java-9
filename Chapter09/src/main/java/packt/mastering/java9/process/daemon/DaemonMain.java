package packt.mastering.java9.process.daemon;

import packt.mastering.java9.process.DemoOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class DaemonMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        DemoOutput.out(new File(".").getAbsolutePath().toString());
        if (args.length == 0) {
            System.err.println("Usage: daemon directory");
            System.exit(-1);
        }
        Set<Parameters> params = parametersSetFrom(args[0]);
        Thread t = new Thread(new ControlDaemon(params));
        t.start();
    }

    private static Set<Parameters> parametersSetFrom(String directory) throws IOException {
        return Files.walk(Paths.get(directory))
                .map(Path::toFile)
                .filter(File::isFile)
                .map(file -> Parameters.fromFile(file))
                .collect(Collectors.toSet());
    }
}
