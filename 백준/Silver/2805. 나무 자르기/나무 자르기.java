import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        sc.close();
        Arrays.sort(arr);
        int left=0;
        int right=arr[n-1];
        long answer=0;
        while(left<=right){
            // if(cnt++==10) break;
            int mid=(left+right)/2;
            long sum=0;
            for(int tree:arr){
                if(tree>mid) sum+=tree-mid;
                if(sum>m) break;
            }
            if(sum>=m){
                answer=answer>mid?answer:mid;
                left=mid+1;
            } 
            if(sum<m) right=mid-1;
        }
        System.out.println(answer);
    }
}