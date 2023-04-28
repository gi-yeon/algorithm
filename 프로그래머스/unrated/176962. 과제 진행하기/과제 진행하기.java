import java.util.*;
class Solution {
    static class Subject implements Comparable<Subject>{
        String name;
        int time;
        int remain;
        Subject(String name, int time, int remain){
            this.name=name;
            this.time=time;
            this.remain=remain;
        }
        public String toString(){
            return "("+name+","+time+","+remain+")";
        }
        public int compareTo(Subject other){
            return this.time-other.time;
        }
    }
    public String[] solution(String[][] plans) {
        Subject[] subjects=new Subject[plans.length];
        for(int i=0;i<plans.length;i++){
            String[] plan=plans[i];
            String[] temp=plan[1].split(":");
            int time=Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            int remain=Integer.parseInt(plan[2]);
            subjects[i]=new Subject(plan[0],time,remain);
        }
        PriorityQueue<Subject> pq=new PriorityQueue<>();
        LinkedList<Subject> list=new LinkedList<>();
        for(Subject sub:subjects) pq.offer(sub);
        ArrayList<String> finish=new ArrayList<>();
        while(!pq.isEmpty()){
            Subject now=pq.poll();
            int finishTime=now.time+now.remain;
            if(!pq.isEmpty()){
                Subject next=pq.peek();
                if(next.time<finishTime){
                    now.remain-=next.time-now.time;
                    list.offerLast(now);
                }else{
                    finish.add(now.name);
                    if(next.time>finishTime){
                        int remain=next.time-finishTime;
                        while(remain>0){
                            if(!list.isEmpty()){
                                Subject wait=list.peekLast();
                                if(wait.remain>remain){
                                    wait.remain-=remain;
                                    remain=0;
                                }else{
                                    finish.add(wait.name);
                                    list.pollLast();
                                    remain-=wait.remain;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                }
            }else{
                finish.add(now.name);
            }
        }
        while(!list.isEmpty()){
            finish.add(list.pollLast().name);
        }
        String[] answer = new String[finish.size()];
        int size=finish.size();
        for(int i=0;i<size;i++){
            answer[i]=finish.get(i);
        }
        return answer;
    }
}