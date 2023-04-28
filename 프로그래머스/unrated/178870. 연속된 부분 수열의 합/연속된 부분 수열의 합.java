import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int length=sequence.length;
        int[] arr=new int[length];
        arr[0]=sequence[0];
        for(int i=0;i<length;i++){
            if(sequence[i]==k) return new int[]{i,i};
        }
        for(int i=1;i<length;i++){
            arr[i]=arr[i-1]+sequence[i];
        }
        int start=0;
        int end=1;
        int sum=sequence[start]+sequence[end];
        int idx=length;
        int a=0;
        int b=0;
        // System.out.println(Arrays.toString(arr));
        while(start<end){
            // System.out.println("start : "+start+", end : "+end+", sum : "+sum);
            if(sum>k){
                sum-=sequence[start];
                start++;
            }else if(sum<k){
                end++;
                if(end==length) break;
                sum+=sequence[end];
            }else if(sum==k){
                if(idx>end-start){
                    idx=end-start;
                    a=start;
                    b=end;
                }
                sum-=sequence[start];
                start++;
            }
        }
        int[] answer = {a,b};
        return answer;
    }
}