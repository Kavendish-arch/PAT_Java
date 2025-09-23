
public class SubstringRemoval {

    public static void main(String[] args) {
        // 测试用例
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(canBeEqualAfterRemoval(a, b) ? "YES" : "NO");
        }
    }

    private static boolean canBeEqualAfterRemoval(String a, String b) {
        // 如果b是a的前缀，那么删除a中b之后的部分即可
        if (a.startsWith(b)) {
            return true;
        }
        // 如果b是a的后缀，那么删除a中b之前的部分即可
        if (a.endsWith(b)) {
            return true;
        }
        // 对于其他情况，我们需要检查b是否是a的子串，并且删除b在a中的前后部分后，a的前后部分能够拼接成b
        return a.contains(b);
    }
}
