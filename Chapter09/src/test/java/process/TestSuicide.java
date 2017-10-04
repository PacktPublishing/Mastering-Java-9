package process;

import org.junit.Test;

public class TestSuicide {

    @Test(expected = IllegalStateException.class)
    public void processCanNotDestroyItself(){
        ProcessHandle.current().destroy();
    }
    @Test(expected = IllegalStateException.class)
    public void processCanNotDestroyItselfForcibly(){
        ProcessHandle.current().destroyForcibly();
    }
}
