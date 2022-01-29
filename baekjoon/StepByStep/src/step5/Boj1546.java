package step5;

import java.util.Scanner;

public class Boj1546 {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0, max = -1;

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            sum += (float)x;

            if(x > max) max = x;
        }

        System.out.printf("%.3f", (sum * 100)/(n * max));

    }
}
