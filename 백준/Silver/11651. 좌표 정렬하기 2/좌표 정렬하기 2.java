import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<List<Integer>> list = new ArrayList<>();
		
		int x,y;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        x = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        list.add(Arrays.asList(x,y));
	    }
	    
	    Collections.sort(list,(a,b)->!a.get(1).equals(b.get(1)) ? 
	    a.get(1) - b.get(1) : a.get(0) - b.get(0));
	    
	    for(List li : list){
	        System.out.println(li.get(0)+" "+li.get(1));
	    }
	}
}

