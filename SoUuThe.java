package javaoop;

import java.util.Scanner;

public class SoUuThe {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String number = in.nextLine();
            if (isNumber(number)) {
                System.out.println(isSoUuThe(number) ? "YES" : "NO");
            } else {
                System.out.println("INVALID");
            }
        }
    }

    public static boolean isNumber(String number) {
        String regex = "^[1-9]{1}[0-9]+";
        return number.matches(regex);
    }

    public static boolean isSoUuThe(String number) {
        int len = number.length();
        int chan = 0;
        int le = 0;
        for (int i = 0; i < len; i++) {
            if ((number.charAt(i) - '0') % 2 == 0) {
                chan++;
            } else {
                le++;
            }
        }
        return (len % 2 == 0 && chan > le) || (len % 2 != 0 && le > chan);
    }
}
