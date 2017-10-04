module mylibrary {
    exports packt.java9.deep.moduledemo.mylibrary to main, notMain;
    requires transitive thirdpartylibrary;
}