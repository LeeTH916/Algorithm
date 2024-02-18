import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int[] list = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        list[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int s = 0;
	    int e = 1;
	    int sum = list[s];
	    int ans = 0;
	    while(e<N){
	        if(sum == M) ans++;
	        
	        if(sum >= M) sum -= list[s++];
	        else if(sum <= M) sum += list[e++];
	        
	        if(s==e) sum += list[e++];
	    }
	    while(s<e){
	        if(sum == M) ans++;
	        
	        sum -= list[s++];
	    }
	    System.out.println(ans);
	}
}
