import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        
        // boj_10871
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        String answer = "";

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(a < x) answer += a + " ";
        }

        System.out.print(answer);

        // boj_2439
        /*
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        //System.out.println(num);

        for (int i = 1 ;i <= num; i++){
            
            //System.out.println(i);
            String tmp = "";
            for (int j = 0; j < num - i; j++){
                tmp += " ";
            }
            for (int j = 0; j < i; j++){
                tmp += "*";
            }
            System.out.print(tmp);
            if (i < num){
                System.out.println();
            }
        }

        // boj_2438
        /*
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i<= n ;i++){
            String tmp = "";
            for(int j=0;j<i;j++) tmp += "*";
            System.out.println(tmp);
        }

        // boj_11022
        /*
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 1; i<= t; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
        }

        // boj_11021
        /*
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 1; i <= t; i++){

            int a = sc.nextInt(), b = sc.nextInt();
            System.out.printf("Case #%d: %d\n", i, a+b);
        }

        // boj_2742
        /*
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = n; i > 0; i--) System.out.println(i);

        // boj_2741
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) System.out.println(i);

        // boj_15552
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i = 0; i<t; i++){
            String arr[] = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            bw.write(a + b + "\n");
        }
        bw.flush();

        // boj_8393
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print((n * (n + 1)) / 2);

        // boj_10950
        /*
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a + b); 
        }

        // boj_2739
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i < 10; i++){
            System.out.printf("%d * %d = %d\n", n, i, n*i);
        }
        */
    }
}