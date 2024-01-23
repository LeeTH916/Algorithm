import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> equation = new ArrayList<>();

        long [][] dp = new long[N-1][21];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            equation.add(Integer.parseInt(st.nextToken()));
        }
        
        dp[0][equation.get(0)] = 1;
        
        for(int i=0;i<N-2;i++){
            for(int j=0;j<21;j++){
                if(j+equation.get(i+1) <= 20)
                    dp[i+1][j+equation.get(i+1)] += dp[i][j];
                if(j-equation.get(i+1) >= 0)
                    dp[i+1][j-equation.get(i+1)] += dp[i][j];
            }
        }
        
        System.out.println(dp[N-2][equation.get(N-1)]);

        

	}
}
