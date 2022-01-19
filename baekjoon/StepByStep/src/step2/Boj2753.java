package step2;

import java.util.Scanner;

public class Boj2753 {
    public static void main(String [] args){
        
        // boj_2753
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if((year%4 == 0 && year%100 != 0) || year % 400 == 0)
            System.out.print(1);
        else System.out.print(0);

    }
}