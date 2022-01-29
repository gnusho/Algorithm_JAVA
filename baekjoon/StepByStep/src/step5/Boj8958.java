package step5;

import java.util.Scanner;

public class Boj8958 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            String x = sc.next();
            int score = 0, weight = 0;

            for(int j = 0; j < x.length(); j++){
                if(x.charAt(j) == 'O') weight++;
                else if(x.charAt(j) == 'X') weight=0;
                score += weight;
            }

            System.out.println(score);
        }

    }
}
