import java.util.ArrayList;
import java.util.Scanner;

public class Problem2623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int a = 0,b = 0;
        String[] inputArr = input.split(" ");
        for (String c : inputArr) {
            if (a == 0) {
                a = Integer.parseInt(c);
                continue;
            }

            if (b == 0) {
                b = Integer.parseInt(c);
            }
        }

        ArrayList<Integer> a_commonFactors = new ArrayList<>();
        ArrayList<Integer> b_commonFactors = new ArrayList<>();


        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                a_commonFactors.add(i);
            }
        }

        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                b_commonFactors.add(i);
            }
        }

        int maximumCommonFactor = 0;
        for (int i = 0; i < a_commonFactors.size(); i++) {
            if (i >= b_commonFactors.size())
                break;
            int temp = a_commonFactors.get(i);
            for (int j = 0; j < b_commonFactors.size(); j++) {
                if (temp == b_commonFactors.get(j)) {
                    maximumCommonFactor = temp;
                    break;
                }
            }
        }
        System.out.println(maximumCommonFactor);
    }
}
