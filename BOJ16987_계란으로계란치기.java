import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16987_계란으로계란치기 {
    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "durability=" + durability +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int N, maxCnt;
    static List<Egg> eggList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        eggList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggList.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        hit(0);

        System.out.println(maxCnt);
    }

    // idx 번째 계란으로 다른 계란을 칠 거야
    private static void hit(int idx) {
        // 계란 다 들어봤으면 끝
        if (idx == N) {
            int cnt = 0;
            for (Egg egg : eggList) {
                if (egg.durability <= 0) {
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }

        // 만약 다 깨져서 칠 애가 없으면 다음 계란으로 이동
        // 지금 들어본 애가 깨져있으면 다음 애로 넘어가
        boolean isAllBroken = true;
        for (int i = 0; i < N; i++) {
            if (i != idx && eggList.get(i).durability > 0) {
                isAllBroken = false;
                break;
            }
        }
        if (eggList.get(idx).durability <= 0 || isAllBroken) {
            hit(idx + 1);
            return;
        }

        // 칠 계란이 있는 경우
        for (int i = 0; i < N; i++) {
            if (i == idx || eggList.get(i).durability <= 0) continue;

            Egg egg = eggList.get(idx);
            Egg target = eggList.get(i);

            target.durability -= egg.weight;
            egg.durability -= target.weight;
            hit(idx + 1);
            target.durability += egg.weight;
            egg.durability += target.weight;
        }
    }
}
