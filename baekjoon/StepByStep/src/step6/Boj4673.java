package step6;

public class Boj4673 {
    public static void main(String [] args) {

        int[] ans = new int[10001];
        ans = d();
        for(int i = 1; i< 10001; i++)
            if(ans[i] == 0) System.out.println(i);
    }

    public static int [] d(){
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
}
