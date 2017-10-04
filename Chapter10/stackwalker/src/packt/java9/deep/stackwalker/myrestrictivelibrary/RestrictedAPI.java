package packt.java9.deep.stackwalker.myrestrictivelibrary;

public class RestrictedAPI {

    public void hello(){
        CheckEligibility.itIsNotCallBack();
        System.out.println("hello");
    }

    public void callMe(Runnable cb){
        cb.run();
    }
}
