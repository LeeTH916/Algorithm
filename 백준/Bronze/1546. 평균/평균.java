import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        double[] scores = new double[N]; 
        double max = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextDouble();
            if (scores[i] > max) 
                max = scores[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (scores[i] / max) * 100;
        }

        System.out.println(sum / N);
    }
}
