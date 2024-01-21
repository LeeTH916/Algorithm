import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] atm = new Integer[n];

        for(int i=0;i<n;i++){
            atm[i] = sc.nextInt();
        }

        Arrays.sort(atm, (a,b) -> a - b);

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += atm[i] * (n-i);
        }

        System.out.println(sum);

    }
}