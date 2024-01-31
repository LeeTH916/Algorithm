import java.util.Scanner;

public class Main {
	static int N, M;
	static int num[];
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				System.out.print("" + num[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			num[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[M];
		
		comb(0,1);
	}
}
