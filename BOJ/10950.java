
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcase = sc.nextInt();
        sc.nextLine();

        int[] a = new int[tcase];
        int[] b = new int[tcase];

        for (int i = 0; i < tcase; i++) {

            do {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
                sc.nextLine();
            } while (!((a[i] > 0) && (b[i] < 10)));

        }

        for (int i = 0; i < tcase; i++) {
            System.out.println(a[i] + b[i]);
        }

        sc.close();
    }
}
