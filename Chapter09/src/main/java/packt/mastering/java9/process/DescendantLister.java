package packt.mastering.java9.process;

import java.io.IOException;
import java.util.stream.Collectors;

public class DescendantLister {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            new ProcessBuilder().command("cmd.exe","/K","cmd").start();
        }
        System.out.println("Number of descendants: " +
                ProcessHandle.current().descendants().count());
    }
}
