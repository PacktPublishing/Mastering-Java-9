package packt.java9.deep.moduledemo.main;

import packt.java9.deep.moduledemo.compiletime.CompileTime;
import packt.java9.deep.moduledemo.mylibrary.MyLibraryAPI;
import packt.java9.deep.moduledemo.thirdpartylibrary.ThirdpartylibraryAPI;

public class Main {

    public static void main(String[] args) {
        CompileTime ct = new CompileTime();
        ThirdpartylibraryAPI api = MyLibraryAPI.getAPI();
        api.printHello();
    }

}
