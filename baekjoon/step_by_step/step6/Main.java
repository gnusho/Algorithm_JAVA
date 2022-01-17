import java.util.Scanner;

public class Main{

    public static void main(String [] args) {

        // boj_1065
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        int n = sc.nextInt();
        System.out.println(m.han(n));
        
        // boj_4673
        /*
        Main m = new Main();
        int[] ans = new int[10001];
        ans = m.d();
        for(int i = 1; i< 10001; i++)
            if(ans[i] == 0) System.out.println(i);
        */
    }

    public int han(int n){
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

    // boj_4673
    /*
    public int [] d(){
        int[] nums = new int[10001];
        for(int i=1;i<10001;i++){
            
            if(nums[i] != 0) continue;
            int tmp = i;

            while(true){
                tmp += tmp%10 + (tmp/10)%10 + (tmp/100)%10 + tmp/1000;
                if(tmp > 10000) break;
                nums[tmp] = 1; 
            }
        }

        return nums;
    }
    // boj_15596
    /*
    public long sum(int[] a){
        long sum = 0;
        for(int x:a) sum +=x;
        return sum;
    }
    */
}