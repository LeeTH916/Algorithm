import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) { 
                count += n / 5;
                n = 0;
                break;
            } else { 
                n -= 2;
                count++;
            }
        }
        
        if (n < 0) { 
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
