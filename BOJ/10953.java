
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
                String data = sc.next();
                String[] str = new String(data).split(",");
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[1]);
            } while ( !((a > 0) && (b < 10)));
            arr[i] = a + b;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
}