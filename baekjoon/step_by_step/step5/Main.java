import java.util.Scanner;

public class Main{

    public static void main(String [] args) {

        // boj_4344
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while(t-- > 0){
            
            int n = sc.nextInt();
            int[] num = new int[n];
            double sum = 0;

            for(int i =0; i < n; i++){
                num[i] = sc.nextInt();
                sum += num[i];
            }

            double avg = sum/n, p = 0;

            for(int i =0; i < n; i++){
                if(num[i] > avg) p++;
            }

            System.out.printf("%.3f%%\n", (p*100)/n);
        }

        // boj_8958
        /*
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

        // boj_1546
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0, max = -1;

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            sum += (float)x;

            if(x > max) max = x;
        }

        System.out.printf("%.3f", (sum * 100)/(n * max));

        // boj_3052
        /*
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

        // boj_2577
        /*
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

        // boj_2526
        /*
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

        // boj_10818
        /*
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = -1000000, min = 1000000;
        
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(min > x) min = x;
            if(max < x) max = x;
        }

        System.out.printf("%d %d", min, max);
        */
    }
}