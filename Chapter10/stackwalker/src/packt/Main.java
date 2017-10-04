package packt;

import static java.lang.StackWalker.Option.SHOW_HIDDEN_FRAMES;
import static java.lang.StackWalker.Option.SHOW_REFLECT_FRAMES;

public class Main {
  public static void main(String[] args) {
    simpleCall();
  }

  static void simpleCall() {
    reflectCall();
  }

  static void reflectCall() {
    try {
      Main.class.getDeclaredMethod("lambdaCall",
          new Class[0])
          .invoke(null, new Object[0]);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }


  static void lambdaCall() {
    Runnable r = () -> {
      walk();
    };
    r.run();
  }

  static void walk() {
    noOptions();
    System.out.println();
    reflect();
    System.out.println();
    hidden();
  }


  static void noOptions() {
    StackWalker
        .getInstance()
        .forEach(System.out::println);
  }

  static void hidden() {
    StackWalker
        // shows also reflect frames
        .getInstance(SHOW_HIDDEN_FRAMES)
        .forEach(System.out::println);
  }

  static void reflect() {
    StackWalker
        .getInstance(SHOW_REFLECT_FRAMES)
        .forEach(System.out::println);
  }

}
