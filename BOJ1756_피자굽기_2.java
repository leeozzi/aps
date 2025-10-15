import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1756_피자굽기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] oven = new int[D + 1];
        for (int i = 1; i < D + 1; i++) {
            if (i != 1) {
                oven[i] = Math.min(oven[i - 1], Integer.parseInt(st.nextToken()));
            } else {
                oven[i] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] pizzas = new int[N];
        for (int i = 0; i < N; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        int minDepth = -1;
        int start = D;

        for (int i = 0; i < N; i++) {
            boolean fit = false;

            for (int j = start; j > 0; j--) {
                if (oven[j] < pizzas[i]) continue;

                minDepth = j;
                start = minDepth - 1;
                fit = true;
                break;
            }

            if(!fit) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(minDepth);
    }
}
