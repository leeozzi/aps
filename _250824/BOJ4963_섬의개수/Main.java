package _250824.BOJ4963_섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while (!str.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];
            cnt = 0;

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
            str = br.readLine();
        }

        System.out.println(sb);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}
