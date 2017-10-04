package packt.java9.deep.moduledemo.notmain;

import packt.java9.deep.moduledemo.mylibrary.MyLibraryAPI;
import packt.java9.deep.moduledemo.thirdpartylibrary.ThirdpartylibraryAPI;

public class NotMain {

    public static void main(String[] args) {
        ThirdpartylibraryAPI api = MyLibraryAPI.getAPI();
        api.printHello();
    }

}
