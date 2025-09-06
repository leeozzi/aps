package DoIt알고리즘코딩테스트자바편;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P004_구간합구하기2_BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] orgMap = new int[N][N];
        int[][] sumMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                orgMap[i][j] = Integer.parseInt(st.nextToken());
                sumMap[i][j] = j == 0 ? orgMap[i][j] : sumMap[i][j - 1] + orgMap[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                if (y1 == y2) {
                    sum += orgMap[j][y1];
                } else {
                    if(y1 != 0) {
                        sum += (sumMap[j][y2] - sumMap[j][y1 - 1]);
                    } else {
                        sum += (sumMap[j][y2]);
                    }
                }
            }

            System.out.println(sum);
        }
    }
}
