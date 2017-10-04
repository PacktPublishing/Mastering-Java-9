package packt.java9.deep.stackwalker.externalcode;

import packt.java9.deep.stackwalker.myrestrictivelibrary.RestrictedAPI;

public class DirectCall {

    public static void main(String[] args) {
        RestrictedAPI api = new RestrictedAPI();
        api.hello();
        api.callMe(() -> {
            api.hello();
        });
    }
}