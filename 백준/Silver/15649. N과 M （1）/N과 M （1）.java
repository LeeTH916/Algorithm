import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] visit;
	
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new int[N];
		NM(0);
	}
	
	static void NM(int cnt) {
		if(cnt == M) {
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visit[i-1] == 0) {
				list.add(i);
				visit[i-1] = 1;
				NM(cnt + 1);
				list.remove(list.size()-1);
				visit[i-1] = 0;
			}
		}
		
	}

}
