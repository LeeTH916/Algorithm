import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    List<Integer> list = new ArrayList<>();
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<N;i++){
	        list.add(Integer.parseInt(br.readLine()));
	    }
	    
	    Collections.sort(list);
	    
	    for(int i=0;i<N;i++){
	        sb.append(list.get(i)+"\n");
	    }
	    System.out.println(sb);
	}
}
