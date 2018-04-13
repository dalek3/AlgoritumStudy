import java.util.Scanner;

public class aplusb4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

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
        for(int p : arr){
            System.out.println(p);
        }
        sc.close();
    }
}
