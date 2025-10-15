import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9456_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = num(st.nextToken());

        // 테스트케이스 반복
        while (T-- > 0) {
            int n = num(br.readLine());
            int[][] stickers = new int[2][n + 1];

            // 스티커판 정보 입력
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = num(st.nextToken());
                }
            }

            // 각 칸을 뽑은 경우의 최댓값
            int[][] dp = new int[2][n + 1];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
//            dp[0][2] = dp[1][1] + stickers[0][2];
//            dp[1][2] = dp[0][1] + stickers[1][2];

            if(n > 1) {
                for (int i = 2; i <= n; i++) {
                    dp[0][i] = Math.max(dp[1][i - 1] + stickers[0][i], dp[1][i - 2] + stickers[0][i]);
                    dp[1][i] = Math.max(dp[0][i - 1] + stickers[1][i], dp[0][i - 2] + stickers[1][i]);
                }
            }
//            System.out.println("=====================================");
//            for(int i = 0 ; i < 2 ; i++) {
//                for(int j = 0 ; j <= n ; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("=====================================");

            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        System.out.println(sb);
    }

    public static int num(String input) {
        return Integer.parseInt(input);
    }
}
