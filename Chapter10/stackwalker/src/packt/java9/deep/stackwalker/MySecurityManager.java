package packt.java9.deep.stackwalker;

public class MySecurityManager extends SecurityManager {
    public Class[] getClassContext(){
        return super.getClassContext();
    }
}
