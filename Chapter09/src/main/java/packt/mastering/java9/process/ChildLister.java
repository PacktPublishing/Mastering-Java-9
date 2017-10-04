package packt.mastering.java9.process;

import java.io.IOException;

public class ChildLister {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            new ProcessBuilder().command("cmd.exe").start();
        }
        System.out.println("Number of children :" +
                ProcessHandle.current().children().count());
    }
}
