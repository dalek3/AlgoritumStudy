import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int LIMIT = 10;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = s.length();
        /*
        ArrayList 크기를 미리 지정하는 이유 :
         저장할 요소의 개수를 고려해서 실제 저장할 개수보다 약간 여유있는 
        크기로 하는 것이 좋다. 처리시간이 많이 소요되기 때문 
        */
        List<String> list = new ArrayList<>(length / LIMIT / 10);

        // length() 문자열을 길이
        for (int i = 0; i < length; i += LIMIT) {
            if (i + LIMIT < length) {
                list.add(s.substring(i, i + LIMIT));
            } else {
                list.add(s.substring(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        sc.close();
    }
}
