import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] max_dp2, max_dp1, min_dp1, min_dp2;
        max_dp1 = new int[3];
        max_dp2 = new int[3];
        min_dp1 = new int[3];
        min_dp2 = new int[3];
        int[] in = new int[3];
        int max, min;
        max = min = 0;
        for (int j = 0; j < 3; j++) {
            in[j] = sc.nextInt();
            max_dp1[j] = min_dp1[j] = in[j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                in[j] = sc.nextInt();
            }
            max_dp2[0] = Math.max(max_dp1[0], max_dp1[1]) + in[0];
            max_dp2[1] = Math.max(Math.max(max_dp1[0], max_dp1[1]), max_dp1[2]) + in[1];
            max_dp2[2] = Math.max(max_dp1[1], max_dp1[2]) + in[2];
            min_dp2[0] = Math.min(min_dp1[0], min_dp1[1]) + in[0];
            min_dp2[1] = Math.min(Math.min(min_dp1[0], min_dp1[1]), min_dp1[2]) + in[1];
            min_dp2[2] = Math.min(min_dp1[1], min_dp1[2]) + in[2];
            for (int j = 0; j < 3; j++) {
                max_dp1[j] = max_dp2[j];
                min_dp1[j] = min_dp2[j];
            }
        }
        max = Math.max(Math.max(max_dp1[0], max_dp1[1]), max_dp1[2]);
        min = Math.min(Math.min(min_dp1[0], min_dp1[1]), min_dp1[2]);
        System.out.println(max+" "+min);
    }
}
