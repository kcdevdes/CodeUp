import java.util.Scanner;

public class Problem2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] input = new double[5];
        for (int i = 0; i < 5; i++ ){
            input[i] = Double.parseDouble(sc.nextLine());
        }

        double minPasta = 2000; // 파스타 최댓값
        double minJuice = 2000; // 주스 최댓값
        for (int i = 0; i < 3; i++) {
            if (input[i] < minPasta)
                minPasta = input[i];
        }
        for (int i = 3; i< 5; i++) {
            if (input[i] < minJuice) {
                minJuice = input[i];
            }
        }

        System.out.println((minJuice+minPasta) + (minPasta+minJuice)/10);
    }
}
