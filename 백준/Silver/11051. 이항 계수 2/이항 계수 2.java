import java.util.*;
public class Main
{
    static int[][] dp = new int[1001][1001];
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int K = sc.nextInt();
	    
	    for(int i=0;i<=N;i++){
	        for(int j=0;j<=i;j++){
	            if(j==0 || i==j) dp[i][j] = 1;
	            else dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
	        }
	    }
	    System.out.println(dp[N][K]);
	}
}