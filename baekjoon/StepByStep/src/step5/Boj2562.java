package step5;

import java.util.Scanner;

public class Boj2562 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int max = 0, place = -1;

        for(int i = 0; i<9;i++){
            int x = sc.nextInt();
            if(x > max){
                max = x;
                place = i + 1;
            }
        }
        System.out.printf("%d\n%d", max, place);

    }
}
