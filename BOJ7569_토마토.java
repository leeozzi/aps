import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_토마토 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];   // 토마토 상태 저장할 배열
        int[][][] depth = new int[H][N][M]; // 몇 번째 깊이인지 저장할 배열
        int maxDepth = Integer.MIN_VALUE;

        int unripe = 0; // 안 익은 토마토 개수
        Queue<int[]> queue = new LinkedList<>(); // 익은 토마토들의 좌표를 넣을 거임


        // 입력
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(depth[h][n], -1);
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if(map[h][n][m] == 0) unripe++;
                    else if(map[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                        depth[h][n][m] = 0;
                    }
                }
            }
        }

        // 모든 토마토가 익어있는 상태 => 0
        if(unripe == 0) {
            System.out.println(0);
            return;
        }
        
        // 우선 토마토를 익혀볼까
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[] dz = {-1, 1};

        while(!queue.isEmpty()) {
            // 익은 토마토 하나를 꺼내서
            int[] cur = queue.poll();

            // 우선 사방을 익혀주고
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + cur[1];
                int ny = dy[d] + cur[2];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[cur[0]][nx][ny] == 0 && depth[cur[0]][nx][ny] == -1) {  // 사방에서 안 익은 토마토를 발견하면 && 아직 depth가 지정되지 않은 토마토면
                    queue.add(new int[]{cur[0], nx, ny});   // queue에 넣어주고
                    unripe--;   // 안 익은 토마토 개수를 하나 줄여줘
                    depth[cur[0]][nx][ny] = depth[cur[0]][cur[1]][cur[2]] + 1;  // 내가 방금 뻗어나온 출처보다 depth 하나 더해줌
                    maxDepth = Math.max(depth[cur[0]][nx][ny], maxDepth);
                }
            }

            // 이제 위아래 익혀줄 거임
            for (int d = 0; d < 2; d++) {
                int nz = dz[d] + cur[0];
                if(nz < 0 || nz >= H) continue;
                if(map[nz][cur[1]][cur[2]] == 0 && depth[nz][cur[1]][cur[2]] == -1) {
                    queue.add(new int[]{nz, cur[1], cur[2]});
                    unripe--;
                    depth[nz][cur[1]][cur[2]] = depth[cur[0]][cur[1]][cur[2]] + 1;
                    maxDepth = Math.max(depth[nz][cur[1]][cur[2]], maxDepth);
                }
            }

        }

        // 일단 bfs를 돌려보고 queue가 비었는데 안 익은 토마토가 남아있으면
        // 토마토가 모두 익을 수 없는 상황 => -1
        if(unripe > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(maxDepth);
    }
}
