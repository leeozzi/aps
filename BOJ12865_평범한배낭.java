import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 물건 개수
        int K = Integer.parseInt(st.nextToken());   // 최대 무게
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            weights[n] = Integer.parseInt(st.nextToken());
            values[n] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
