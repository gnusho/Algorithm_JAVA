package step2;

import java.util.Scanner;

public class Boj2884 {
    public static void main(String [] args){
        
        // boj_2884
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        int t = h*60 + m;
        int target = t - 45;
        if(target < 0) target += 24*60;

        System.out.printf("%d %d", target/60, target%60);

    }
}