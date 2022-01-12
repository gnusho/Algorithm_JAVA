import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        
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
    }
}
