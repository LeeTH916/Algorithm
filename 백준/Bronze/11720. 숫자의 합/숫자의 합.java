import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		char[] c = str.toCharArray();
		int answer = 0;
		for(int i=0;i<N;i++){
		    answer += c[i] - '0';
		}
		System.out.println(answer);
	}
}