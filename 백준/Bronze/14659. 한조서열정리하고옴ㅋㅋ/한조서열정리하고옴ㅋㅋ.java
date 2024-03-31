import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if (heights[i] > heights[j]) count++;
                else break;
            }
            if (count > maxCount)  maxCount = count;
        }

        System.out.println(maxCount);
    }
}
