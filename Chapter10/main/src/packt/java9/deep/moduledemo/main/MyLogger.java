package packt.java9.deep.moduledemo.main;

import java.lang.System.Logger;
import java.util.ResourceBundle;

public class MyLogger implements Logger {

  private final String name;

  public MyLogger(String name) {
    this.name = name;
  }


  @Override
  public String getName() {
    return null;
  }

  @Override
  public boolean isLoggable(Level level) {
    return true;
  }

  @Override
  public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
    log(level, bundle, msg);
  }

  @Override
  public void log(Level level, ResourceBundle bundle, String format, Object... params) {
    System.out.println(name + " " + format);
  }
}
