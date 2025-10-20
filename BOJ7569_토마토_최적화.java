import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ7569_토마토_최적화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        int unripe = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 0) unripe++;
                    else if (map[h][n][m] == 1) {
                        q.addLast(((h * N) + m) * M + m);
                    }
                }
            }
        }

        if(unripe == 0) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        int maxDay = 1;
        while(!q.isEmpty()) {
            int curId = q.pollFirst();
            int m = curId % M;  // 한 행 내의 위치
            int hn = curId / M; // 층 + 행 묶음
            int n = hn % N;  // 층 내 행 인덱스
            int h = hn / N; //
        }
    }
}
