package _250823.BOJ4673_셀프넘버;

public class Main_boolean {
    // 다음 수 구해주는 함수
    static int d (int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean[] generated = new boolean[10001];
        // 1부터 10000까지 돌면서
        for (int i = 1; i <= 10000; i++) {
            // 다음 수를 구해보고
            int dn = d(i);
            // 그 다음 수가 10000보다 작으면, generated 배열의 '다음수' 인덱스를 true로 전환
            if(dn <= 10000) generated[dn] = true;
        }

        StringBuilder sb = new StringBuilder();

        // 1부터 10000까지 generated 함수 돌면서 생성자 없는(false)인 인덱스만 출력
        for (int i = 1; i <= 10000; i++) {
            if (!generated[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
