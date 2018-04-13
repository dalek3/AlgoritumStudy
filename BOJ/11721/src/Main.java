import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = 1;
        // length() 문자열을 길이
        for(int i = 0 ; i < s.length(); i++){

            System.out.print(s.charAt(i));

            if(i == (a * 10-1)){
                System.out.println();
                a++;
            }
        }


        sc.close();
    }
}
