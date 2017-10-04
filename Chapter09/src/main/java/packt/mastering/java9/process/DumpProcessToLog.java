package packt.mastering.java9.process;

import packt.mastering.java9.LogFinder.Get;

import java.time.Duration;
import java.time.Instant;

import static java.lang.System.Logger.Level.DEBUG;

public class DumpProcessToLog {
    private static final System.Logger log = Get.logger();

    public static void dump(ProcessHandle handle) {
        ProcessHandle.Info info = handle.info();
        StringBuffer sb = new StringBuffer();
        sb.append("Command: " + info.command().orElse("??") + "\n");
        sb.append("Command Line: " + info.commandLine().orElse("not present") + "\n");
        sb.append("Arguments: " + String.join(" ", info.arguments().orElse(new String[0])) + "\n");
        sb.append("Number of commandLine: " + info.arguments().orElse(new String[0]).length + "\n");
        sb.append("CPU: " + info.totalCpuDuration().orElse(Duration.ZERO) + "\n");
        sb.append("Start time: " + info.startInstant().orElse(Instant.EPOCH) + "\n");
        sb.append("User: " + info.user().orElse("??") + "\n");
        sb.append("Pid: " + handle.getPid() + "\n");
        sb.append("Children" + "\n");
        handle.children().forEach(child -> sb.append("child pid:" + child.getPid() + "\n"));
        sb.append("Descendants" + "\n");
        handle.descendants().forEach(descendant -> sb.append("descendant pid:" + descendant.getPid() + "\n"));

        handle.parent().ifPresentOrElse(parent -> sb.append("Parent: " + parent.info()), () -> sb.append("no parent\n"));

        if (handle.parent().isPresent() &&
                handle.parent().get().info().startInstant().isPresent() &&
                handle.info().startInstant().isPresent()) {
            sb.append("Parent started me after " +
                    Duration.between(handle.parent().get().info().startInstant().get(),
                            handle.info().startInstant().get()).toMillis() + "ms" + "\n");
        }
        sb.append("toString " + handle.info().toString() + "\n");

        log.log(DEBUG, sb.toString());
    }

}
