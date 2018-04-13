
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        int[] arr = new int[tcase];
        int[] a = new int[tcase];
        int[] b = new int[tcase];

        for (int i = 0; i < arr.length; i++) {
            do {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
                sc.nextLine();
            } while (!((a[i] > 0) && (b[i] < 10)));
            arr[i] = a[i] + b[i];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + a[i] + " + " + b[i] + " = " + arr[i]);
        }

        sc.close();
    }
}