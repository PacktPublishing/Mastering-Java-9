package packt.mastering.java9.stackwalker;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DumpStack {
    public static void dump(PrintStream out) {
        dump(out, new HashSet<>());
    }

    public static void dump(PrintStream out, Set<StackWalker.Option> options) {
        StackWalker.getInstance(options).walk(
                s -> s.peek(
                        frame -> out.printf("%s:%d:%s %s:%d:%s()\n",
                                frame.getClassName(),
                                frame.getByteCodeIndex(),
                                (options.contains(StackWalker.Option.RETAIN_CLASS_REFERENCE) ? frame.getDeclaringClass().getSimpleName() : ""),
                                frame.getFileName(),
                                frame.getLineNumber(),
                                frame.getMethodName()
                        )
                ).filter(x -> false).collect(Collectors.toList()));
    }

}
