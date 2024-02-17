import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        boolean[] map = new boolean[20000001];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            int card = Integer.parseInt(st.nextToken());
            map[card+10000000] = true;
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(map[Integer.parseInt(st.nextToken()) + 10000000]) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);
	}
}
