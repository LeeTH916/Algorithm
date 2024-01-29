import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		
		InputStreamReader is = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(is);
		StringTokenizer st;
		
		int[][] arr = new int[19][19];
		
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(arr[i][j] != 0) {
					
					int v = arr[i][j];
					
					int[] a = {0, 1, -1 ,1};
					int[] b = {1, 1, 1, 0};
					
					for(int k=0;k<4;k++) {
						int next_i = i;
						int next_j = j;
						int cnt = 0;

						while(arr[next_i][next_j] == v) {
							cnt++;
							next_i += a[k];
							next_j += b[k];
							
							if(next_i < 0 || next_i >= 19 || next_j < 0 || next_j >= 19) break;
						}
						if(cnt == 5) {
	    					next_i = i - a[k];
							next_j = j - b[k];
						    if(next_i >= 0 && next_i < 19 && next_j >= 0 && next_j < 19) {
						        if(arr[next_i][next_j] == v) continue;
						    }
							print(v,i+1,j+1);
							return;
						}
					}
				} 
			}
		}
		System.out.println(0);

	}
	
	public static void print(int win,int i,int j) {
		System.out.println(win);
		System.out.println("" + i + " " + j);
	}
}

