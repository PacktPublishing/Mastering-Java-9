package packt.mastering.java9.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import static packt.mastering.java9.process.DemoOutput.out;

public class StartChild {
    private static final String classpath = "build/classes/main";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ProcessHandle.Info me = ProcessHandle.current().info();
        String command = me.command().get();
        Process process = new ProcessBuilder(command, "-classpath", classpath, DumpThisProcess.class.getName()).start();
        ProcessHandle handle = process.toHandle();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("*" + line + "*");
        }

        handle.onExit().thenAccept(
                ph -> out(" exit value of the process {0}", process.exitValue())
        ).get();
    }

}
