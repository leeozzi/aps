package _250823.BOJ4673_셀프넘버;

import java.util.BitSet;

public class Main_BitSet {
    // 다음수 구하는 함수 d
    static int d(int n){
        int s = n;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        BitSet gen = new BitSet(10001);
        for (int i = 1; i <= 10000; i++) { // 1부터 10000까지 가면서
            int dn = d(i); // 다음수 구해보고
            if (dn <= 10000) { // 10000 이하면
                gen.set(dn); // dn 인덱스에 bit 할당
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {  // BitSet 전체 훑으면서
            if (!gen.get(i)) {  // bit 할당 안 된 애 있으면
                sb.append(i).append('\n');  // 출력
            }
        }
        System.out.println(sb);
    }
}
