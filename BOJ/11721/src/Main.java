import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final int LIMIT = 10;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int line = 1;
        
        // length() 문자열을 길이
        for(int i = 0 ; i < s.length(); i++){

            System.out.print(s.charAt(i));

            if(i == (line * LIMIT-1)){
                System.out.println();
                line++;
            }
        }


        sc.close();
    }
}
