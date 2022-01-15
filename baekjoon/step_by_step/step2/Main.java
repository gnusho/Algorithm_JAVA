import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        
        // boj_2884
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        int t = h*60 + m;
        int target = t - 45;
        if(target < 0) target += 24*60;

        System.out.printf("%d %d", target/60, target%60);

        // boj_14681
        /*
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x>0){
            if(y>0) System.out.print(1);
            else if(y<0) System.out.print(4);
        }
        else if(x<0){
            if(y>0) System.out.print(2);
            else if(y<0) System.out.print(3);
        }

        // boj_2753
        /*
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if((year%4 == 0 && year%100 != 0) || year % 400 == 0)
            System.out.print(1);
        else System.out.print(0);

        // boj_9498
        /*
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if(x>=90 && x<=100) System.out.print("A");
        else if(x>=80 && x<90) System.out.print("B");
        else if(x>=70 && x<80) System.out.print("C");
        else if(x>=60 && x<70) System.out.print("D");
        else System.out.print("F");

        // boj_1330
        /*
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b) System.out.print(">");
        else if(a<b) System.out.print("<");
        else System.out.print("==");
        */
    }
}