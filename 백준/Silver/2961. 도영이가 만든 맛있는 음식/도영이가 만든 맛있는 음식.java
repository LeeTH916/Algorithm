import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] s;
	static int[] ss;
	
	static int min = Integer.MAX_VALUE;
	static int N;
	static int visit = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		ss = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			ss[i] = Integer.parseInt(st.nextToken());
		}
		
		sub(0);
		
		System.out.println(min);

	}
	
	static void sub(int cnt) {
		if(cnt == N) {
			int a = 1;
			int b = 0;
			
			if(visit == 0) return;
			for(int i=0;i<N;i++) {
				if((visit & (1<<i)) != 0) {
					a *= s[i];
					b += ss[i];
				}
			}
			min = Math.min(Math.abs(a-b), min);
			return;
		}
		
		visit |= 1<<cnt;
		sub(cnt+1);
		visit &= ~(1<<cnt);
		sub(cnt+1);
	}
}
