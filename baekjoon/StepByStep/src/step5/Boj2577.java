package step5;

import java.util.Scanner;

public class Boj2577 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] num = new int[10];
        for(int i = 0; i < 10; i++) num[i] = 0;
        int n = a * b * c;

        while(n != 0){
            num[n%10]++;
            n /= 10;
        }

        for(int i = 0; i < 10; i++) System.out.println(num[i]);

    }
}
