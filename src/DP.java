import java.util.ArrayList;
import java.util.Scanner;

public class DP {
    // https://blog.naver.com/kks227/220777103650
    // 기초 DP 프로그래밍

    static Scanner sc = new Scanner(System.in);

    /**
     * 1 : Fibonacci Recursive Function with DP
     */

//    static ArrayList<Integer> dp = new ArrayList<>();
//
//    static int fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//
//        // 이미 계산했던 결과라면 바로 그 값을 리턴
//        if (dp.get(n) != -1) return dp.get(n);
//        // 아닐 시, 값을 계산하여 리스트에 저장
//        dp.set(n, fibonacci(n-2) + fibonacci(n-1));
//
//        return dp.get(n);
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 0; i < N+1; i++) {
//            dp.add(-1); // 몽땅 -1로 초기화해버리기
//        }
//
//        System.out.println(fibonacci(N));
//    }


    /**
     * 2. Fibonacci Iteration from the lowest value
     */
//    public static void main(String[] args){
//        int N = sc.nextInt();
//        sc.nextLine();
//        ArrayList<Integer> dp = new ArrayList<>();
//        dp.add(0); // 0번째
//        dp.add(1); // 1번째
//        for (int i = 2; i <= N; i++) {
//            dp.add(dp.get(i-1) + dp.get(i-2));
//        }
//        System.out.println(dp.get(N));
//    }

    /**
     * 3. BAEKJOON
     */
    static ArrayList<Integer> dp = new ArrayList<>(1000001);

    static int f(int n) {
        if (n == 1) return 0;
        if (dp.get(n) != -1) return dp.get(n);

        int result = f(n - 1) + 1;
        if (n % 3 == 0) result = Math.min(result, f(n/3) + 1);
        if (n % 2 == 0) result = Math.min(result, f(n/2) + 1);
        dp.set(n, result);
        //System.out.println("N : " + n + " COUNT : " + result);
        return result;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <= 1000001; i++) {
            dp.add(0);
        }
        for (int i = 1; i <= n; i++) {
            dp.set(i, Math.min(dp.get(i+1), dp.get(i) + 1));
            if (i*2 < n) dp.set(i*2, Math.min(dp.get(i*2), dp.get(i) + 1));
            if (i*3 < n) dp.set(i*3, Math.min(dp.get(i*3), dp.get(i) + 1));
        }
        System.out.println(dp.get(n));
    }
}
