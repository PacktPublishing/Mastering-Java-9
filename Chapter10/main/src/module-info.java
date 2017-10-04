import packt.java9.deep.moduledemo.main.MyLoggerFinderProvider;

module main {
  requires mylibrary;
  requires
  //    static
  compiletime;
  provides java.lang.System.LoggerFinder
      with MyLoggerFinderProvider;
}