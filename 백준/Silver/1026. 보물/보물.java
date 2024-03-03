import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[][] list = new Integer[2][N];
		
		for(int i=0;i<2;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        list[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		Arrays.sort(list[0]);
		Arrays.sort(list[1], Collections.reverseOrder());
		
		int answer = 0;
		for(int i=0;i<N;i++){
		    answer += list[0][i] * list[1][i];
		}
		
		System.out.println(answer);
	}
}