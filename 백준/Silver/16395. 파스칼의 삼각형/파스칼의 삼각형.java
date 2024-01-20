import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k,n;
		k = sc.nextInt();
		n = sc.nextInt();
		
		System.out.println(combination(k-1,n-1));
		
	}
	
	static int combination(int n, int r){
	    if(n == r || r == 0) return 1;
	    return combination(n-1,r-1) + combination(n-1,r);
	}
}