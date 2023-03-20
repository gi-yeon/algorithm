import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        Arrays.sort(arr);
        int m = sc.nextInt();
        long[] targets = new long[m];
        for (int i = 0; i < m; i++)
            targets[i] = sc.nextLong();
        for (long target : targets) {
            boolean isPossible = false;
            int l = 0;
            int r = n-1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] == target) {
                    isPossible = true;
                    break;
                } else if (arr[mid] < target) {
                    l = mid + 1;
                } else if (arr[mid] > target) {
                    r = mid - 1;
                }
            }
            int answer = isPossible?1:0;
            System.out.println(answer);
        }
    }
}
