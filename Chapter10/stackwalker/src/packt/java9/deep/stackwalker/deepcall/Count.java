package packt.java9.deep.stackwalker.deepcall;

public class Count {

  private static final int MAX_STCK_DEPTH = 300;

  public static void main(String[] args) {
    recursive(0);
  }

  public static void recursive(int i) {
    if (i < MAX_STCK_DEPTH) {
      recursive(i + 1);
    } else {
      System.out.println("" +
          StackWalker.getInstance().walk(s -> s.count()));
    }
  }


}
