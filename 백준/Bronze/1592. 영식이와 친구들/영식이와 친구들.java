import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		
		arr[0] = 1;
		int cur = 0;
		int cnt = 0;
		while(true){
		    if(arr[cur] == M) break;
		    if(arr[cur] %2 == 0) cur = (cur + L)%N;
		    else cur = (cur + N -L)%N;
		    
		    arr[cur]++;
		    cnt++;
		}
		System.out.println(cnt);
	}
}
