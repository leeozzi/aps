package DoIt알고리즘코딩테스트자바편;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P002_평균구하기_BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[n];
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, scores[i]);
        }
        double sum = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += (scores[i] * 100.0 / maxScore);
        }
        System.out.println(sum / n);
    }
}
