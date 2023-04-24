import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int[] dp=new int[k+1];
        Arrays.fill(dp,987654321);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int now=arr[i];
            for(int j=now;j<=k;j++){
                if(dp[j]>dp[j-now]+1){
                    dp[j]=dp[j-now]+1;
                }
            }
        }
        int ans=-1;
        if(dp[k]!=987654321) ans=dp[k];
        System.out.println(ans);
    }
}
