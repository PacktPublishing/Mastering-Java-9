package packt.java9.deep.stackwalker.logretriever;

import java.lang.System.Logger;
import java.lang.System.LoggerFinder;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

public class Labrador {
  public static Logger retrieve() {
    final Class clazz = StackWalker
        .getInstance(RETAIN_CLASS_REFERENCE)
        .getCallerClass();
    return LoggerFinder.getLoggerFinder().getLogger(
        clazz.getCanonicalName(), clazz.getModule());
  }
}
