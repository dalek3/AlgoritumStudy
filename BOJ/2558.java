
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        do {
            a = sc.nextInt();
            // 엔터를 nextLine()로 받아서 처리
            sc.nextLine();
            b = sc.nextInt();
        } while (!((a > 0) && (b < 10)));

        System.out.println(a + b);

        sc.close();
    }
}
