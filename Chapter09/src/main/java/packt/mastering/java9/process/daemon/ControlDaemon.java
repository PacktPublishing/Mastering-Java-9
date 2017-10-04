package packt.mastering.java9.process.daemon;

import packt.mastering.java9.LogFinder.Get;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class ControlDaemon implements Runnable {
    private static final System.Logger log = Get.logger();

    private final Set<ParamsAndHandle> handlers;

    public ControlDaemon(Set<Parameters> params) {
        handlers = params
                .stream()
                .map(s -> new ParamsAndHandle(s, null))
                .collect(Collectors.toSet());
    }

    @Override
    public void run() {
        try {
            for (ParamsAndHandle pah : handlers) {
                log.log(DEBUG, "Starting {0}", pah.params);
                ProcessHandle handle = start(pah.params);
                pah.handle = handle;
            }
            keepProcessesAlive();
            while (handlers.size() > 0) {
                allMyProcesses().join();
            }
        } catch (IOException e) {
            log.log(ERROR, e);
        }
    }

    private void keepProcessesAlive() {
        anyOfMyProcesses()
                .thenAccept(ignore -> {
                            restartProcesses();
                            keepProcessesAlive();
                        }
                );
    }

    private void restartProcesses() {
        Set<ParamsAndHandle> failing = new HashSet<>();
        handlers.stream()
                .filter(pah -> !pah.toHandle().isAlive())
                .forEach(
                        pah -> {
                            try {
                                pah.handle = start(pah.params);
                            } catch (IOException e) {
                                failing.add(pah);
                            }
                        }
                );
        handlers.removeAll(failing);
    }

    private CompletableFuture anyOfMyProcesses() {
        return CompletableFuture.anyOf(
                completableFuturesOfTheProcesses());
    }

    private CompletableFuture allMyProcesses() {
        return CompletableFuture.allOf(
                completableFuturesOfTheProcesses());
    }

    private CompletableFuture[] completableFuturesOfTheProcesses() {
        return handlers.stream()
                .map(ParamsAndHandle::toHandle)
                .map(ProcessHandle::onExit)
                .collect(Collectors.toList())
                .toArray(new CompletableFuture[handlers.size()]);
    }

    private ProcessHandle start(Parameters params)
            throws IOException {
        log.log(DEBUG, "process to start: {0}",
                String.join(" ", params.commandLine));
        return new ProcessBuilder(params.commandLine)
                .start()
                .toHandle();
    }
}
