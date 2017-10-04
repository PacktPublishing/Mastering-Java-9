package packt.mastering.java9.LogFinder;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

/**
 * Get the system logger that is identified by the name of the calling class,
 * and configure the default JUL logger to log everything.
 *
 * The naming is the usual logger naming convention in most of the cases.
 *
 * Libraries using this method can exeute their tests satandalone logging
 * on all level to the JVM JUL logging framework, and can use the logger of
 * the application when they are outside of test.
 */
public class Get {
    /**
     * Configure the JUL Logger that is identified by the caller's class and
     * then return the logger for the same class returned by System.getLogger.
     * By default this is the same that is configured in JUL, but may be different
     * when the library is used in an application and the application decides to
     * configure the logging different.
     *
     * @return the logger for the caller class.
     */
    public static System.Logger logger() {
        final String callerClassName =
                StackWalker.getInstance(RETAIN_CLASS_REFERENCE)
                        .getCallerClass().getName();
        Logger logger =
                Logger.getLogger(callerClassName);
        logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        return System.getLogger(callerClassName);
    }
}
