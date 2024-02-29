import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int flag = 0;
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new int[9];
		
		for(int i=0;i<9;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list);
		
		combination(0,0,0,0);
	}
	
	static void combination(int cnt, int start, int visited, int sum) {
		if(flag == 1) return;
		if(cnt == 7) {
			if(sum == 100) {
				flag = 1;
				for(int i=0;i<9;i++) {
					if((visited & 1<<i)!=0) System.out.println(list[i]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			if((visited & 1<<i)==0) {
				combination(cnt+1,i+1,visited | 1<<i,sum+list[i]);
			}
		}
	}
}
