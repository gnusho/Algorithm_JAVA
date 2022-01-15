import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        
        // boj_1110
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x = n;
        
        while(true){   
            x = (x%10) * 10 + (x%10 + x/10)%10;
            ans++;
            if(n == x) break;
        }

        System.out.println(ans);

        // boj_10951
        /*
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a + b);
        }

        // boj_10952
        /*
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a + b == 0) break;

            System.out.println(a+b);
        }
        */
    }
}
