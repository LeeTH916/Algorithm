import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,X,K;
	static int[] cup;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 1;
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cup = new int[N+1];
			cup[X] = 1;
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				swap(a,b);
			}
			
			for(int i=1;i<=N;i++) {
				if(cup[i] == 1) {
					sb.append(i);
					break;
				}
			}
		}
		System.out.println(sb);
		
	}
	
	static void swap(int idx1, int idx2) {
		int temp = cup[idx1];
		cup[idx1] = cup[idx2];
		cup[idx2] = temp;
	}
}
