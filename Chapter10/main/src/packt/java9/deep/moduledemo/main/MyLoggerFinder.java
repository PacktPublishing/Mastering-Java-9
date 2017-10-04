package packt.java9.deep.moduledemo.main;

import java.lang.System.Logger;
import java.lang.System.LoggerFinder;
import java.lang.reflect.Module;

public class MyLoggerFinder extends LoggerFinder {

    protected MyLoggerFinder(){}

    @Override
    public Logger getLogger(String name, Module module) {
        return new MyLogger(name);
    }
}
