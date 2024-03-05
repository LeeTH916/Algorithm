import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static List<Integer> list = new ArrayList<>();
	static int[] x = {-1,0,1,0};
	static int[] y = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int j=a;j<c;j++) {
				for(int k=b;k<d;k++) {
					map[k][j] = 1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					list.add(doBFS(new Point(j,i)));
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	
	static int doBFS(Point cur) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(cur);
		map[cur.y][cur.x] = 1;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Point c = queue.poll();
			
			for(int i=0;i<4;i++) {
				int ny = c.y + y[i];
				int nx = c.x + x[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				
				if(map[ny][nx] == 0) {
					map[ny][nx] = 1;
					cnt++;
					queue.add(new Point(nx,ny));
				}
			}
			
		}
		return cnt;
	}
}
