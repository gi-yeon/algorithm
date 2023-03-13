class Solution {
    public long solution(int[] arr) {
        long answer = 0;
        long[] dp=new long[arr.length];
        dp[0]=arr[0];
        long max=dp[0];
        for(int i=1;i<arr.length;i++){
            int now=arr[i];
            if(i%2==1){
                dp[i]=dp[i-1]-now>-1*now?dp[i-1]-now:-1*now;
            }else{
                dp[i]=dp[i-1]+now>now?dp[i-1]+now:now;
            }
            max=max>dp[i]?max:dp[i];
        }
        dp=new long[arr.length];
        dp[0]=-1*arr[0];
        max=max>dp[0]?max:dp[0];
        for(int i=1;i<arr.length;i++){
            int now=arr[i];
            if(i%2==1){
                dp[i]=dp[i-1]+now>now?dp[i-1]+now:now;
            }else{
                dp[i]=dp[i-1]-now>-1*now?dp[i-1]-now:-1*now;
            }
            max=max>dp[i]?max:dp[i];
        }
        answer=max;
        return answer;
    }
}