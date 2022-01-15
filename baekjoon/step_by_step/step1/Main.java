import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        
        // boj_2588
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a * (b%10));
        System.out.println(a * ((b/10) % 10));
        System.out.println(a * (b/100));
        System.out.print(a * b);

        // boj_10430
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        
        System.out.println((a+b)%c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a*b)%c);
        System.out.print(((a%c)*(b%c))%c);

        // boj_10869
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.print(a%b);

        // boj_1008
        /*
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();

        System.out.printf("%.10f", a/b);

        // boj_10998
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a*b);

        // boj_1001
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a-b);

        // boj_1000
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a+b);

        // boj_10172
        /*
        String x = "|\\_/|\n"
                    + "|q p|   /}\n"
                    + "( 0 )\"\"\"\\\n"
                    + "|\"^\"`    |\n"
                    + "||_/=\\\\__|";

        System.out.print(x);
        
        // boj_10171
        /*
        String x = "\\    /\\\n" 
                + " )  ( ')\n" 
                + "(  /  )\n" 
                + " \\(__)|";
        System.out.print(x);

        // boj_10718
        /*
        String x = "강한친구 대한육군";
        System.out.println(x);
        System.out.print(x);

        // boj_2557
        /*
        System.out.print("Hello World!");
        */        
    }
}