
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        int[] arr = new int[tcase];

        int a;
        int b;

        for (int i = 0; i < arr.length; i++) {
            do {
                a = sc.nextInt();
                b = sc.nextInt();
                sc.nextLine();
            } while (!((a > 0) && (b < 10)));
            arr[i] = a + b;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Case #" + (i+1) + ": " + arr[i]);
        }

        sc.close();
    }
}