
public final class test {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String ab = "ab";

        System.out.println(ab == "ab");
        System.out.println(ab == (a + b));
        System.out.println(ab.equals(a + b));
        System.out.println(ab.equals("ab"));
    }
}
