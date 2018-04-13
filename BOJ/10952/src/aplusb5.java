
import java.util.ArrayList;
import java.util.Scanner;

public class aplusb5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList(5);

        int a;
        int b;

        do {

            do {
                a = sc.nextInt();
                b = sc.nextInt();
                sc.nextLine();
            } while (!((a >= 0) && (b < 10)));

            if (!((a == 0) && (b == 0))) {
                arr.add(a + b);
            }

        } while (!((a == 0) && (b == 0)));

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        sc.close();
    }
}




