
import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0;i<photo.length;i++){
            int sum=0;
            for(String str:photo[i]){
                if(!map.containsKey(str)) continue;
                sum+=map.get(str);
            }
            answer[i]=sum;
        }
        return answer;
    }
}