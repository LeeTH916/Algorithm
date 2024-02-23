import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] order;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		order = new int[9];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(0, 1);

		check();
		System.out.println(max);
	}
	
	static void permutation(int cnt, int visited) {
		if(cnt==9) {
			check();
			return;
		}
		
		if(cnt == 3) {
			order[cnt] = 0;
			permutation(cnt+1,visited | 1);
			return;
		}

		for(int i=1;i<9;i++) {
			if((visited & (1<<i)) == 0) {
				order[cnt] = i;
				permutation(cnt+1, visited | (1<<i));
			}
		}
	}
	
	static void check() {
		int score = 0;
		int j = 0;
		
		for(int i=0;i<N;i++) {
			int out = 0;
			long temp = 0;
			while(out<3) {
				int state = map[i][order[j++%9]];
				if(state==0) {
					out++;
					score += Long.bitCount(temp>>3);
					temp &= 0b111;
				}
				else {
					temp = temp << state;
					temp |= 1<<(state-1);
				}
			}
		}
		max = Math.max(max, score);
	}
}
