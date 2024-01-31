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
		
		int[][] arr = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==0 && j==0) continue;
				else if(i == 0) arr[i][j] += arr[i][j-1];
				else if(j == 0) arr[i][j] += arr[i-1][j];
				else arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}

		sb.append("");
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from_y = Integer.parseInt(st.nextToken());
			int from_x = Integer.parseInt(st.nextToken());
			
			int to_y = Integer.parseInt(st.nextToken());
			int to_x = Integer.parseInt(st.nextToken());
			
			if(from_y == 1 && from_x == 1)  sb.append(arr[to_y-1][to_x-1]).append("\n");
			else if(from_y == 1) sb.append(arr[to_y-1][to_x-1] - arr[to_y-1][from_x-2]).append("\n");
			else if(from_x == 1) sb.append(arr[to_y-1][to_x-1] - arr[from_y-2][to_x-1]).append("\n");
			else sb.append(arr[to_y-1][to_x-1] - arr[from_y-2][to_x-1]- arr[to_y-1][from_x-2] + arr[from_y-2][from_x-2]).append("\n");
		}
		
		System.out.println(sb);
	}
}
