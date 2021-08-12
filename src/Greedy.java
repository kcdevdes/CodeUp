import java.util.Scanner;

public class Greedy {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int money = 1000 - sc.nextInt();
        int [] kinds = {500, 100, 50, 10, 5, 1};
        int idx = 0, ans = 0;
        while (money != 0) {
            int change = money / kinds[idx];
            money -= change * kinds[idx++];
            ans += change;
        }
        System.out.println(ans);
    }
}
