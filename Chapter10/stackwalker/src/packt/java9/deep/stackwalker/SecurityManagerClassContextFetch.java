package packt.java9.deep.stackwalker;

public class SecurityManagerClassContextFetch {

    public static void main(String[] args) {
        for (final Class c : new MySecurityManager().getClassContext()) {
            System.out.println(c.getCanonicalName());
        }
    }
}
