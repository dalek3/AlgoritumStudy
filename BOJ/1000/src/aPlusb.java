
import java.util.Scanner;

public class aPlusb {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;

        do {
            a = sc.nextInt();
            b = sc.nextInt();
        }while(!((a > 0) && (b < 10)));

        System.out.println(a+b);


    }
}
