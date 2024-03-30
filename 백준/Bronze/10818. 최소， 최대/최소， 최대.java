import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numbers = new int[N];

        numbers[0] = sc.nextInt();
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < N; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }

        System.out.println(min + " " + max);
    }
}
