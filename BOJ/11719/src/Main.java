import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;

        do {
            a = Integer.parseInt(sc.next().trim());
        } while (!((a >= 1) && (a <= 100)));

        int[] b = new int[a];
        String s = sc.next();
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }


        int result = 0;
        for (int i = 0; i < b.length; i++) {
            result += b[i];
        }
        System.out.println(result);

    }
}
