package step5;

import java.util.Scanner;

public class Boj4344 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while(t-- > 0){
            
            int n = sc.nextInt();
            int[] num = new int[n];
            double sum = 0;

            for(int i =0; i < n; i++){
                num[i] = sc.nextInt();
                sum += num[i];
            }

            double avg = sum/n, p = 0;

            for(int i =0; i < n; i++){
                if(num[i] > avg) p++;
            }

            System.out.printf("%.3f%%\n", (p*100)/n);
        }

    }
}
