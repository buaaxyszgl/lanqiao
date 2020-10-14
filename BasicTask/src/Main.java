import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[][] dp4;
    private static List<List<Integer>> v = new ArrayList<>();

    public static void main(String[] args) {
        prev1();
        //alo2();
        //alo3();
        //alo4();
        //basic10();
        //basic11();
        //basic12();
        //basic13();

    }

    private static void basic10() {  // 10 radix to 16 radix
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            System.out.println(0);
        }
        while (n > 0) {
            int t = n % 16;
            if (9 < t && t < 16) {
                sb.append((char) ('A' + t - 10));
            } else {
                sb.append(t);
            }
            n = n / 16;
        }
        System.out.println(sb.reverse().toString());
    }

    private static void basic11() { //16进制转10进制
        Scanner scanner = new Scanner(System.in);
        long ans = 0;
        String s = scanner.nextLine();
        for (char t : s.toCharArray()) {
            if (t >= 'A' && t <= 'F') {
                ans = ans * 16 + t - 'A' + 10;
            } else {
                ans = ans * 16 + t - '0';
            }
        }
        //System.out.println(ans);

        System.out.println(Long.valueOf(s, 16));
    }

    private static void basic12() { // 16 radix to 8 radix
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n > 0) {
            n--;
            String s = scanner.next();
            basic12_helper(s);
        }
    }

    private static void basic12_helper(String s) {
        // 16 - 8
        StringBuilder sb = new StringBuilder();  // sb is 16 - 2
        for (char i : s.toCharArray()) {
            int temp = 0;
            if ('A' <= i && i <= 'F') {
                temp = i - 'A' + 10;
            } else {
                temp = i - '0';
            }
            StringBuilder tempS = new StringBuilder();
            while (temp != 0) {
                tempS.append((temp % 2));
                temp = temp / 2;
            }
            if (tempS.length() != 4) {
                for (int j = tempS.length(); j < 4; j++) {
                    tempS.append(0);
                }
            }
            sb.append(tempS.reverse().toString());
        }
        //System.out.println(sb.toString());
        //sb = sb.reverse();
        StringBuilder sb8 = new StringBuilder();
        char[] store2 = sb.toString().toCharArray();
        int cnt = 0, to8 = 0, ra = 1;
        for (int i = store2.length - 1; i >= 0; i--) {
            if (cnt == 3) {
                cnt = 0;
                sb8.append(to8);
                to8 = 0;
                ra = 1;
            }
            to8 += (store2[i] - '0') * ra;
            ra = ra * 2;
            cnt++;
        }
        if (to8 != 0) {
            sb8.append(to8);
        }
        while (sb8.toString().endsWith("0")) {
            sb8 = sb8.deleteCharAt(sb8.length() - 1);
        }
        String ans = sb8.reverse().toString();
        System.out.println(ans);
    }

    private static void basic13() { //数列排序
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[n - 1]);
    }

    private static void alo2() {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        scanner.close();

        if (n <= 2) {
            System.out.print(n);
            return;
        }

        if (0 == n % 2) {
            // Even.
            if (0 != n % 3) {
                System.out.print((n * (n - 1) * (n - 3)));
            } else {
                System.out.print((n - 1) * (n - 2) * (n - 3));
            }
        } else {
            // Odd.
            System.out.print(n * (n - 1) * (n - 2));
        }
    }

    private static void alo3() {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int L = scanner.nextInt();
        scanner.close();

        int[][] dp = new int[L + 1][k];

        for (int i = 0; i < k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= L; i++) {
            for (int j = 0; j < k; j++) {
                for (int a = 0; a < k; a++) {
                    if (a != j - 1 && a != j + 1) {
                        dp[i][j] += dp[i - 1][a];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < k; i++) {
            ans += dp[L][i];
            ans %= 1000000007;
        }
        System.out.println(ans);
        return;
    }

    private static void alo4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp4 = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            dp4[i][1] = scanner.nextInt();
            v.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            v.get(a).add(b);
            v.get(b).add(a);
        }
        alo4_helper(1, 0);
        System.out.println(Math.max(dp4[1][0], dp4[1][1]));
    }

    private static void alo4_helper(int root, int pre) {
        List<Integer> t = v.get(root);
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) != pre) {
                alo4_helper(t.get(i), root);
                dp4[root][1] += dp4[t.get(i)][0];
                dp4[root][0] += Math.max(dp4[t.get(i)][0], dp4[t.get(i)][1]);
            }
        }
    }

    private static void prev1(){
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        int t = gcd(a,b);
        t=gcd(t,c);
        System.out.println(t);
    }

    private static int gcd(int a, int b) {
        int n = a, m = b;
        int t;
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        while (b != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return n * m / a;
    }
}
