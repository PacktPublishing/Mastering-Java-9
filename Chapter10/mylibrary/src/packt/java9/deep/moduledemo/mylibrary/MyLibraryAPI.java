package packt.java9.deep.moduledemo.mylibrary;

import packt.java9.deep.moduledemo.thirdpartylibrary.ThirdpartylibraryAPI;

public class MyLibraryAPI {
    public static ThirdpartylibraryAPI getAPI() {
        return new ThirdpartylibraryAPI();
    }
}
