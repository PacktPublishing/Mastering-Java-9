package packt.mastering.java9.process;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TerminateProcess {
    private static final int N = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessHandle ph[] = new ProcessHandle[N];
        for (int i = 0; i < N; i++) {
            final ProcessBuilder pb = new ProcessBuilder().command(
                    //"/Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home/bin/" +
                    "java",
                    "-cp",
                    "build/classes/main",
                    "packt.mastering.java9.process.ChildToBeTerminated");
            Process p = pb.start();
            ph[i] = p.toHandle();
        }
        long start = System.currentTimeMillis();
        Arrays.stream(ph).forEach(ProcessHandle::destroyForcibly);

        CompletableFuture.allOf(
                Arrays.stream(ph).
                        map(ProcessHandle::onExit).
                        collect(Collectors.toList()).
                        toArray(new CompletableFuture[ph.length])
        ).join();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Duration " + duration + "ms");
    }
}
