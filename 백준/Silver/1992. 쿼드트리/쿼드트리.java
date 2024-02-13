import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		encoding(0,0,1);
	}
	
	static void encoding(int y,int x, int cnt) {
		if(check(y,x,cnt)) System.out.print(map[y][x]);
		else {
			System.out.print("(");
			cnt*=2;
			encoding(y,x,cnt);
			encoding(y,x+N/cnt,cnt);
			encoding(y+N/cnt,x,cnt);
			encoding(y+N/cnt,x+N/cnt,cnt);
			System.out.print(")");
		}

	}
	static boolean check(int y,int x, int cnt) {
		int v = map[y][x];
		for(int i=y;i<y+ N/cnt;i++) {
			for(int j=x;j<x + N/cnt;j++) {
				if(map[i][j] != v) return false;
			}
		}
		return true;
	}
}
