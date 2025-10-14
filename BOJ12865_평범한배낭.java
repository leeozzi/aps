import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
    public static class Stuff {
        int weight;
        int value;

        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stuff[] stuffs = new Stuff[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            stuffs[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}
