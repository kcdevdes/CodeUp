import java.util.Scanner;

public class Problem3127 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] charArr = input.toCharArray();
        // 마지막에 공백이 있다면, 쓰이지 않는 문자를 넣어 switch 처리에서
        // 걸리지 않도로 처리
        if (charArr[charArr.length - 1] == ' ') {
            charArr[charArr.length - 1] = '|';
        }

        Stack numberStack = new Stack();

        StringBuilder number = new StringBuilder(); // 숫자 저장용
        for (char c : charArr) {
            int a, b;
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    number.append(c);
                    break;
                case ' ': // 띄어쓰기를 만나면 그때까지 저장해둔 숫자를 put()
                    if (number.toString().equals("")) // 만약 그냥 비었다면
                        break;
                    numberStack.put(Integer.parseInt(number.toString()));
                    number = new StringBuilder(); // 초기화
                    break;
                case '+':
                    a = numberStack.pop();
                    b = numberStack.pop();
                    numberStack.put(b + a); // 스택에서 먼저 나온 값이 뒤로 가야한다.
                    break;
                case '-':
                    a = numberStack.pop();
                    b = numberStack.pop();
                    numberStack.put(b - a); // 스택에서 먼저 나온 값이 뒤로 가야한다.
                    break;
                case '*':
                    a = numberStack.pop();
                    b = numberStack.pop();
                    numberStack.put(b * a); // 스택에서 먼저 나온 값이 뒤로 가야한다.
                    break;
                case '/':
                    a = numberStack.pop();
                    b = numberStack.pop();
                    numberStack.put(b / a); // 스택에서 먼저 나온 값이 뒤로 가야한다.
                    break;
                default:
                    break;
            }
        }

        System.out.println(numberStack.pop());
    }
}

class Stack {
    int[] stackData = new int[200];
    int sizeOfData = 0;

    public void put(int value) {
        this.stackData[sizeOfData] = value;
        sizeOfData++;
    }

    public int pop() {
        int value = stackData[sizeOfData - 1];
        stackData[sizeOfData - 1] = 0;
        sizeOfData--;

        return value;
    }
}
