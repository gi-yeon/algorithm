import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int length=minerals.length%5==0?minerals.length/5:minerals.length/5+1;
        int[][] stamina=new int[length][3];
        int dia,iron,stone;
        dia=iron=stone=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((int[] a, int[] b)->{return b[2]-a[2];});
        int crawl=(picks[0]+picks[1]+picks[2])*5;;
        for(int i=0;i<minerals.length;i++){
            if(crawl==0){
                break;
            }
            crawl--;
            if(minerals[i].equals("diamond")){
                stamina[i/5][0]++;
                stamina[i/5][1]+=5;
                stamina[i/5][2]+=25;
            }
            else if(minerals[i].equals("iron")){
                stamina[i/5][0]++;
                stamina[i/5][1]++;
                stamina[i/5][2]+=5;
            }
            else{
                stamina[i/5][0]++;
                stamina[i/5][1]++;
                stamina[i/5][2]++;
            }
        }
        for(int[] i:stamina) System.out.println(Arrays.toString(i));
        for(int[] st:stamina) pq.offer(st);
        int cnt=0;
        for(int p:picks) cnt+=p;
        while(!pq.isEmpty()){
            int[] now=pq.poll();
            if(picks[0]>=1){
                answer+=now[0];
                picks[0]--;
            }else if(picks[1]>=1){
                answer+=now[1];
                picks[1]--;
            }else if(picks[2]>=1){
                answer+=now[2];
                picks[2]--;
            }else{
                break;
            }
        }
        return answer;
    }
}