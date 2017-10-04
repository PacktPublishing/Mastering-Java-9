package packt.mastering.java9.process;

import java.lang.ProcessHandle.Info;

public class ProcessLister {

    private static void out(String format, Object... params) {
        System.out.println(String.format(format, params));
    }

    private static boolean looksLikeJavaProcess(Info info) {
        return info.command().isPresent() &&
                info.command().get().
                        toLowerCase().indexOf("java") != -1;
    }

    public static void main(String[] args) {
        ProcessHandle.allProcesses().
                map(ProcessHandle::info).
                filter(info -> looksLikeJavaProcess(info)).
                forEach(
                        (info) -> System.out.println(
                                info.command().orElse("---"))
                );
    }

}
