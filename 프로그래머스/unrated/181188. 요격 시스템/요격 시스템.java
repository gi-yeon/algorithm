import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        PriorityQueue<double[]> pq=new PriorityQueue<>((double[] a, double[] b)->{return b[1]-a[1]<0?-1:1;});
        for(int[] target:targets) {
            pq.offer(new double[]{target[0]+0.1,target[1]-0.1});
        }
        double limit=pq.peek()[0];
        while(!pq.isEmpty()){
            double[] now=pq.poll();
            if(now[1]<limit){
                limit=now[0];
                answer++;
            }else if(now[0]>limit){
                limit=now[0];
            }
        }
        return answer;
    }
}