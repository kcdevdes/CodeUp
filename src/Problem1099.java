import java.util.Scanner;

public class Problem1099 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[10];
        String[][] noSpaceInput = new String[10][10];
        char[][] charArr = new char[10][10];
        for (int i = 0; i < 10; i++ ) {
            input[i] = sc.nextLine();
            noSpaceInput[i] = input[i].split(" ");
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                charArr[i][j] = noSpaceInput[i][j].charAt(0);
            }
        }

        int cursor = 1;

        loop:
        for (int i = 1; i < 9; i++) {
            for (int j = cursor; j < 9; j++) {
                // 먹이 발견 즉시 중지
                if (charArr[i][j] == '2') {
                    charArr[i][j] = '9';
                    break loop; // 완전히 탈출
                }
                // 벽에 막힐 때
                if (charArr[i][j+1] == '1') {
                    charArr[i][j] = '9';
                    cursor = j;
                    break; // i 루프로 돌아가 한 줄을 건너뛰기
                }
                // 막다른 길, 중지
                if (charArr[i][j+1] == '1' && charArr[i+1][j] == '1') {
                    charArr[i][j] = '9';
                    break loop; // 완전히 탈출
                }
                // 먹이거나 빈 상황에선 현재 위치에 9를 찍고 직진
                if (charArr[i][j+1] == '0' || charArr[i][j+1] == '2') {
                    charArr[i][j] = '9';
                }
            }
        }

        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(charArr[k][j] + " ");
            }
            System.out.println();
        }

    }
}
