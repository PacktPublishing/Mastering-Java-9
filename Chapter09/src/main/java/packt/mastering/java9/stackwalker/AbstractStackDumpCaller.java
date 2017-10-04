package packt.mastering.java9.stackwalker;

import java.util.EnumSet;

public abstract class AbstractStackDumpCaller {

    public abstract void calme();

    void dumper(){
        DumpStack.dump(System.out);//, EnumSet.of(StackWalker.Option.RETAIN_CLASS_REFERENCE));
    }

}
