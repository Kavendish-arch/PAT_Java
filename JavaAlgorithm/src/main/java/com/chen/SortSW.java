
import java.util.Arrays;
import java.util.Scanner;

public class SortSW {

    public static boolean canMakeSorted(int[] a, int[] b) {
        if (isSorted(a) || isSorted(b)) {
            return true;
        }

        int n = a.length;
        int[] ascA = a.clone();
        int[] descA = a.clone();
        int[] ascB = b.clone();
        int[] descB = b.clone();

        Arrays.sort(ascA);
        Arrays.sort(ascB);
        Arrays.sort(descA);

        for (int i = 0; i < n / 2; i++) {
            int temp = descA[i];
            descA[i] = descA[n - 1 - i];
            descA[n - 1 - i] = temp;
        }
        
        Arrays.sort(descB);
        for (int i = 0; i < n / 2; i++) {
            int temp = descB[i];
            descB[i] = descB[n - 1 - i];
            descB[n - 1 - i] = temp;
        }

        boolean[] conflictA = new boolean[n];
        boolean[] conflictB = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (a[i] != ascA[i] && a[i] != descA[i]) {
                conflictA[i] = true;
            }
            if (b[i] != ascB[i] && b[i] != descB[i]) {
                conflictB[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (conflictA[i] && conflictB[i]) {
                // Try to swap to resolve conflicts
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;

                // Check if resolved
                if ((a[i] == ascA[i] || a[i] == descA[i]) && (b[i] == ascB[i] || b[i] == descB[i])) {
                    conflictA[i] = false;
                    conflictB[i] = false;
                } else {
                    // Swap back if not resolved
                    temp = a[i];
                    a[i] = b[i];
                    b[i] = temp;
                }
            }
        }

        return !hasTrue(conflictA) || !hasTrue(conflictB);
    }

    private static boolean isSorted(int[] arr) {
        boolean ascending = true;
        boolean descending = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
            if (arr[i] < arr[i + 1]) {
                descending = false;
            }
        }
        return ascending || descending;
    }

    private static boolean hasTrue(boolean[] arr) {
        for (boolean b : arr) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casees = in.nextInt();

        for (int c = 0; c < casees; c++) {

            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            if (canMakeSorted(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
