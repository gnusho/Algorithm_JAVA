package step6;

import java.util.Scanner;

public class Boj1065 {
	public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(han(n));

    }

    public static int han(int n){
        int ret = 0;

        for(int i=1; i<=n; i++){
            if(i < 100) ret++;
            else{
                int a = i/100;
                int b = (i/10)%10;
                int c = i%10;

                if(a-b == b-c) ret++;
            }
        }

        return ret;
    }
}
