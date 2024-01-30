import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] sw;
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		sw = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) job1(b);
			else if(a == 2) job2(b-1);
		}
		
		
		for(int i=0;i<N/20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(sw[i*20 + j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0;i<N%20;i++) {
			System.out.print(sw[N/20*20 + i] + " ");
		}

	}
	
	static void job1(int n) {
		for(int i=1; n*i <= sw.length; i++) {
			sw[n*i -1] ^= 1;
		}
	}
	
	static void job2(int n) {
		sw[n] ^= 1;
		for(int i=1;i<sw.length/2 ;i++) {
			if( (n-i) >= 0 && (n+i) <sw.length) {
				if(sw[n-i] == sw[n+i]) {
					sw[n-i] ^= 1;
					sw[n+i] ^= 1;
				} else break;
			}
		}
	}
}
