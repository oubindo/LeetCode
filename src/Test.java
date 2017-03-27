/**
 * Created by oubin on 17-3-25.
 */
public class Test {
    private static String name = "outer";
    private int age;

    static class Inner {
        public Inner() {
            System.out.println(name + ".Inner");
        }
    }

    public static void fin(String name) {
        class Fun {
            public Fun() {
                super();
                System.out.println(name);
            }
        }

    }

    public static void main(String[] args) {
        Inner inner = new Inner();

    }
}
