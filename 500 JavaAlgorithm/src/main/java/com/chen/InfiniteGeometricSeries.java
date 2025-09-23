package com.chen;

import java.util.Scanner;

public class InfiniteGeometricSeries {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(sumOfGeometricSeries(a, b));
        }
    }

    public static String sumOfGeometricSeries(int a, int k) {


        int fenmu = 1 * (int) Math.pow(10, k) - a;
        int gcd = GCD(fenmu, a);
        int simpleFenZi = a / gcd;
        int simpleFenmu = fenmu / gcd;
        return simpleFenZi + "/" + simpleFenmu;

    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }


}
