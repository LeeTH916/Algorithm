import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}

		sb.append("");
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from_y = Integer.parseInt(st.nextToken());
			int from_x = Integer.parseInt(st.nextToken());
			
			int to_y = Integer.parseInt(st.nextToken());
			int to_x = Integer.parseInt(st.nextToken());
			
			sb.append(arr[to_y][to_x] - arr[from_y-1][to_x]- arr[to_y][from_x-1] + arr[from_y-1][from_x-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
