package packt.mastering.java9.process.daemon;

public class ParamsAndHandle {
    final Parameters params;
    ProcessHandle handle;

    public ParamsAndHandle(Parameters params,
                           ProcessHandle handle) {
        this.params = params;
        this.handle = handle;
    }

    public ProcessHandle toHandle() {
        return handle;
    }
}
