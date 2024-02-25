import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map, modifiedMap;
	static List<Point> list;
	static int[] x = {-1,0,1,0};
	static int[] y = {0,-1,0,1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		modifiedMap = new int[N][N];
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Point(j,i));
				}
			}
		}
		
		combination(0,0,0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min - 2);
	}
	
	static void combination(int cnt, int visited, int start) {
		if(cnt == M) {
			min = Math.min(min,virus(visited));
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			if((visited & 1<<i)==0) {
				combination(cnt+1,visited | 1<<i,i+1);
			}
		}
	}
	
	static int virus(int visited) {
		for(int i=0;i<N;i++) {
			modifiedMap[i] = map[i].clone();
		}
		
		Queue<Point> queue = new ArrayDeque<>();
		
		for(int i=0;i<list.size();i++) {
			Point v = list.get(i);
			if((visited & 1<<i)!=0) {
				modifiedMap[v.y][v.x] = 2; 
				queue.add(v);
			}
			else modifiedMap[v.y][v.x] = -1; 
		}
		
		int max = 2;
		while(!queue.isEmpty()) {
			Point v = queue.poll();
			for(int i=0;i<4;i++) {
				int ny = v.y + y[i];
				int nx = v.x + x[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(modifiedMap[ny][nx]<=0) {
					if(modifiedMap[ny][nx] == 0) {
						modifiedMap[ny][nx] = modifiedMap[v.y][v.x]+1;
						max = Math.max(max, modifiedMap[ny][nx]);
					} else modifiedMap[ny][nx] = modifiedMap[v.y][v.x]+1;
					queue.add(new Point(nx,ny));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(modifiedMap[i][j] == 0) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return max;
	}
}