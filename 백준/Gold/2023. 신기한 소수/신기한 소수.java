import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Integer[] prime = {2,3,5,7};
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<prime.length;j++) {
				for(int k=1;k<=9;k++) {
					int num = prime[j] * 10 + k;
					if(isPrime(num)) list.add(num);
				}
			}
			prime = list.toArray(new Integer[0]);
			list.clear();
		}
		
		for(int i=0;i<prime.length;i++) {
			System.out.println(prime[i]);
		}
		
		
		
	}
	static boolean isPrime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
