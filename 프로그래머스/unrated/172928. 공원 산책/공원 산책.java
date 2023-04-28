import java.util.*;
class Solution {
    static class Route{
        char dir;
        int cnt;
        Route(char dir, int cnt){
            this.dir=dir;
            this.cnt=cnt;
        }
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] map=new char[park.length][park[0].length()];
        int n=park.length;
        int m=park[0].length();
        for(int i=0;i<n;i++){
            map[i]=park[i].toCharArray();
            for(int j=0;j<m;j++){
                if(map[i][j]=='S'){
                    answer=new int[]{i,j};
                }
            }
        }
        Map<String,int[]> dirMap=new HashMap<>();
        dirMap.put("E",new int[]{0,1});
        dirMap.put("S",new int[]{1,0});
        dirMap.put("W",new int[]{0,-1});
        dirMap.put("N",new int[]{-1,0});
        for(String route:routes){
            String[] temp=route.split(" ");
            int[] dir=dirMap.get(temp[0]);
            int cnt=Integer.parseInt(temp[1]);
            boolean isBorder=false;
            int ny=answer[0];
            int nx=answer[1];
            for(int i=0;i<cnt;i++){
                ny+=dir[0];
                nx+=dir[1];
                if(ny<0||nx<0||ny>=n||nx>=m||map[ny][nx]=='X'){
                    isBorder=true;
                    break;
                }
            }
            if(!isBorder){
                answer[0]=ny;
                answer[1]=nx;
            }
        }
        return answer;
    }
}