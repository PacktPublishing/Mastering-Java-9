package packt.java9.deep.stackwalker.myrestrictivelibrary;

import java.util.stream.Stream;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

public class CheckEligibility {

  private static final String packageName
      = CheckEligibility.class.getPackageName();

  private static boolean notInLibrary(
      StackWalker.StackFrame f) {
    return !inLibrary(f);
  }

  private static boolean inLibrary(
      StackWalker.StackFrame f) {
    return f.getDeclaringClass().getPackageName()
        .equals(packageName);
  }

  public static void itIsNotCallBack_() {
    boolean eligible =
        StackWalker
            .getInstance(RETAIN_CLASS_REFERENCE)
            .walk(s ->
                s.dropWhile(CheckEligibility::inLibrary)
                    .dropWhile(CheckEligibility::notInLibrary)
                    .count() == 0
            );
    if (!eligible) {
      throw new IllegalCallerException();
    }
  }

  public static void itIsNotCallBack() {
    Stream<StackWalker.StackFrame> stream =
        StackWalker
            .getInstance(RETAIN_CLASS_REFERENCE)
            .walk(s -> s);
    boolean eligible =
        stream.dropWhile(CheckEligibility::inLibrary)
            .dropWhile(CheckEligibility::notInLibrary)
            .count() == 0;
    if (!eligible) {
      throw new IllegalCallerException();
    }
  }
}
