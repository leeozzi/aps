import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1756_피자굽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] oven = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] pizzas = new int[N];
        for (int i = 0; i < N; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] taken = new boolean[D + 1];   // 해당 층이 찼는지 안 찼는지
        int[] result = new int[D + 1];
        int lastLayer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= D; j++) {
                if (pizzas[i] <= oven[j] && !taken[j]) continue;
                result[j - 1] = pizzas[i];
                taken[j - 1] = true;
                lastLayer = j - 1;
                break;
            }

            if (lastLayer == -1) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(lastLayer);

    }
}