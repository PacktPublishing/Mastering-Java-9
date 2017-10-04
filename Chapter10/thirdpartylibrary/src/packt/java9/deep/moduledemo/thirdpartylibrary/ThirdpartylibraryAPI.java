package packt.java9.deep.moduledemo.thirdpartylibrary;

import packt.java9.deep.stackwalker.logretriever.Labrador;

import java.lang.System.Logger;

public class ThirdpartylibraryAPI {
  Logger LOGGER = Labrador.retrieve();

  public void printHello() {

    LOGGER.log(Logger.Level.ALL, "hello");
  }

}
