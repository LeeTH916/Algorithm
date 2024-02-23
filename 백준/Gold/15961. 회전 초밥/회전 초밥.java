import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N,d,k,c;
	static int[] list;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		int[] visited = new int[d+1];
		
		int s = 0;
		int e = k;
		int cnt = 0;
		for(int i=0;i<k;i++) {
			if(visited[list[i]]== 0) cnt ++;
			visited[list[i]]++;
		}

		int min = 0;
		
		for(int i=0;i<N;i++) {
			if(visited[c] == 0) min = Math.max(min, cnt+1);
			else min = Math.max(min, cnt);
			
			if(visited[list[e++%N]]++ == 0) cnt++;
			if(--visited[list[s++]] == 0) cnt--;
		}
		
		System.out.println(min);
	}
}
