package packt.java9.deep.moduledemo.main;

public class MyLoggerFinderProvider {

    private static MyLoggerFinder INSTANCE = new MyLoggerFinder();

    public static MyLoggerFinder provider(){
        return INSTANCE;
    }
}
