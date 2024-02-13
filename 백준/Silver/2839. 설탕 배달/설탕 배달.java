import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dp[i] = 5000;
		}
		dp[3] = 1;
		if(N>=5) dp[5] = 1;
		for(int i=6;i<=N;i++) {
			if(dp[i-3]!=0) dp[i] = Math.min(dp[i-3] + 1, dp[i]);
			if(dp[i-5]!=0) dp[i] = Math.min(dp[i-5] + 1, dp[i]);
		}
		
		System.out.println(dp[N]==5000?-1:dp[N]);
	}
}