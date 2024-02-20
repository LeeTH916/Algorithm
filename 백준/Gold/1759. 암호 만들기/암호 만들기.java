import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static String[] list;
	static String[] answer;
	static int flag = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new String[M];
		answer = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			list[i] = st.nextToken();
		}
		Arrays.sort(list);
		combination(0,0);
	}
	
	static void combination(int cnt, int start) {
		if(cnt==N ) {
			if(flag > 0 && N-flag>=2) {
				for(int i=0;i<N;i++) {
					System.out.print(answer[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=start;i<M;i++) {
			
			answer[cnt] = list[i];
			if(list[i].charAt(0) == 'a' || list[i].charAt(0) == 'e' || 
					list[i].charAt(0) == 'i' || list[i].charAt(0) == 'o' || list[i].charAt(0) == 'u') {
				flag++;
			}
			combination(cnt+1, i+1);
			if(list[i].charAt(0) == 'a' || list[i].charAt(0) == 'e' || 
					list[i].charAt(0) == 'i' || list[i].charAt(0) == 'o' || list[i].charAt(0) == 'u') {
				flag--;
			}
		}
	}
}
