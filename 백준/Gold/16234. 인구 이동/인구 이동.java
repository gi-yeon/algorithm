import java.util.*;

public class Main {
    static int n, r, l;
    static int[][] map;
    static LinkedList<int[]> list;
    static boolean[][] visited;
    static int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        list = new LinkedList<>();
        visited = new boolean[n][n];
        int cnt = 0;
        while (check()) {
            cnt++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    list.add(new int[] { i, j });
                    visited[i][j] = true;
                    dfs(i, j);
                    if (!list.isEmpty()) {
                        int sum = 0;
                        for (int[] arr : list) {
                            sum += map[arr[0]][arr[1]];
                        }
                        sum /= list.size();
                        for (int[] arr : list) {
                            map[arr[0]][arr[1]] = sum;
                        }
                        list.clear();
                    }
                    list.clear();
                }
            }
        }
        System.out.println(cnt);
    }

    public static void print() {
        System.out.println();
        for (int[] arr : map)
            System.out.println(Arrays.toString(arr));
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if (visited[ny][nx])
                continue;
            int now = Math.abs(map[y][x] - map[ny][nx]);
            if (now <= r && now >= l) {
                visited[ny][nx] = true;
                list.add(new int[] { ny, nx });
                dfs(ny, nx);
            }
        }
    }

    public static boolean check() {
        for (boolean[] arr : visited)
            Arrays.fill(arr, false);
        list.clear();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int now = Math.abs(map[i][j] - map[i][j + 1]);
                if (now <= r && now >= l) {
                    return true;
                }
                now = Math.abs(map[j][i] - map[j + 1][i]);
                if (now <= r && now >= l) {
                    return true;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int now = Math.abs(map[n - 1][i] - map[n - 1][i + 1]);
            if (now <= r && now >= l)
                return true;
            now = Math.abs(map[i][n - 1] - map[i + 1][n - 1]);
            if (now <= r && now >= l)
                return true;
        }
        return false;
    }
}
