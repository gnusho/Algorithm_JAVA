package step5;

import java.util.Scanner;

public class Boj3052 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int[] remain = new int[42];
        
        for(int i = 0; i < 10; i++){
            int x = sc.nextInt();
            remain[x % 42]++;
        }

        int ans = 0;
        for(int i =0;i<42;i++){
            if(remain[i] != 0) ans++;
        }

        System.out.print(ans);

    }
}
