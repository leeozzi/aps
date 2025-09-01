package DoIt알고리즘코딩테스트자바편;

import java.util.Scanner;

public class P001_숫자의합구하기_BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] nums = sc.nextLine().toCharArray();
        int sum = 0 ;
        for(int i = 0 ; i < N ; i++) {
            sum += (nums[i]-'0');
        }
        System.out.println(sum);
    }
}
