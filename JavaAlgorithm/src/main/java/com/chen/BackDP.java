
import java.util.Scanner;

public class BackDP {

    public static boolean canFillBox(int N, int n, int[] a, int c) {

        boolean[] dp = new boolean[N + 1];
        dp[0] = true;  // 容量为0时，不需要装任何东西

        // 动态规划处理玩具
        for (int i = 0; i < n; i++) {
            for (int j = N; j >= a[i]; j--) {
                dp[j] = dp[j] || dp[j - a[i]];
            }
        }

        // 查找填充物能否填满剩余空间
        boolean canFill = false;
        for (int i = 0; i <= N; i++) {
            if (dp[i] && N - i <= c) {
                canFill = true;
                break;
            }
        }

        return canFill;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int casees = in.nextInt();

        for (int ces = 0; ces < casees; ces++) {
            int N = in.nextInt(); // 箱子的容量
            int n = in.nextInt();  // 玩具的数量
            int c = in.nextInt();  // 填充物的数量
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            // 调用函数并打印结果
            if (canFillBox(N, n, a, c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }
        }

    }

}
