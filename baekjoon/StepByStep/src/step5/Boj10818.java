package step5;

import java.util.Scanner;

public class Boj10818 {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = -1000000, min = 1000000;
        
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(min > x) min = x;
            if(max < x) max = x;
        }

        System.out.printf("%d %d", min, max);
    }
}
