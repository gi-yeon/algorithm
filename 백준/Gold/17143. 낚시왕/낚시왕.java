import java.util.*;

public class Main {
    static int r, c, m, loc, ans;
    static ArrayList<Shark> list = new ArrayList<>();
    static PriorityQueue[][] checkList;

    static class Shark {
        int y, x, s, d, z;

        Shark(int row, int col, int speed, int direction, int size) {
            this.y = row;
            this.x = col;
            this.s = speed;
            this.d = direction;
            this.z = size;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "(y : " + y + ", x : " + x + ", d : " + d + ", s : " + s + ", z : " + z + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        m = sc.nextInt();
        if(m==0){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < m; i++) {
            list.add(new Shark(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        checkList = new PriorityQueue[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                checkList[i][j] = new PriorityQueue<Shark>((Shark s1, Shark s2) -> {
                    return s2.z - s1.z;
                });
                for(Shark shark:list){
                    if(shark.y==i&&shark.x==j){
                        checkList[i][j].offer(shark);
                    };
                }
            }
        }
        loc = 0;
        for (int i = 0; i < c; i++) {
            loc++;
            eatAndFishing();
            move();
        }
        System.out.println(ans);
    }
    public static void print(){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                int size=checkList[i][j].isEmpty()?0:((Shark)checkList[i][j].peek()).z;
                System.out.print(size+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void eatAndFishing() {
        list.clear();
        boolean getFish=false;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int size = checkList[i][j].size();
                if (size > 0) {
                    Shark largest = (Shark) checkList[i][j].poll();
                    if(!getFish&&j==loc){
                        getFish=true;
                        ans+=largest.z;
                    }else{
                        list.add(largest);
                    }
                }
                checkList[i][j].clear();
            }
        }
    }

    public static void move() {
        for (Shark shark : list) {
            int len = shark.s;
            while (len != 0) {
                switch (shark.d) {
                    case 1:
                        if (shark.y - len < 1) {
                            len -= shark.y-1;
                            shark.y = 1;
                            shark.d = 2;
                        } else {
                            shark.y -= len;
                            len = 0;
                        }
                        break;
                    case 2:
                        if ((r - shark.y) - len < 1) {
                            len -= (r - shark.y);
                            shark.y = r;
                            shark.d = 1;
                        } else {
                            shark.y += len;
                            len = 0;
                        }
                        break;
                    case 3:
                        if ((c - shark.x) - len < 1) {
                            len -= c - shark.x;
                            shark.x = c;
                            shark.d = 4;
                        } else {
                            shark.x += len;
                            len = 0;
                        }
                        break;
                    case 4:
                        if (shark.x - len < 1) {
                            len -= shark.x-1;
                            shark.x = 1;
                            shark.d = 3;
                        } else {
                            shark.x -= len;
                            len = 0;
                        }
                        break;
                }
            }
            checkList[shark.y][shark.x].add(shark);
        }
    }
}
