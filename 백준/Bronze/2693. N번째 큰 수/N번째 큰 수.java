import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 
        for (int i = 0; i < T; i++) {
            int[] numbers = new int[10];
            for (int j = 0; j < 10; j++) {
                numbers[j] = sc.nextInt(); 
            }

            Arrays.sort(numbers);
            System.out.println(numbers[7]);
        }
    }
}
