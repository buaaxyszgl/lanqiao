import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //basic11();
        basic12();
        //basic13();

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
}
