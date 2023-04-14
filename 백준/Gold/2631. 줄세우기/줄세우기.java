import java.util.*;

public class Main {
    // LIS 사용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int cnt = 0;
        int[] num = new int[n];
        Arrays.fill(num,222);
        for (int i = 0; i < n; i++) {
            for(int j=0;j<=i;j++){
                if(arr[i]<num[j]){
                    num[j]=arr[i];
                    break;
                }
            }
        }
        for(int i:num) cnt=i!=222?cnt+1:cnt;
        System.out.println(n-cnt);
    }
}
// 3752614

// 3526147
// 2356147
// 1235647
// 12345647