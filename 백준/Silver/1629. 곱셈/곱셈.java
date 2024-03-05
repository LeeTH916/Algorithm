import java.util.Scanner;

public class Main {
	static int[] value;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(pow(a,b,c));
	}
	
	static long pow(int a,int b,int c) {
		if(b==0) return 1;
		
		long ret = pow(a,b/2,c);
		ret = (ret * ret)%c;
		if(b%2==1) ret = (ret * a)%c;
		
		return ret;
	}
}