import java.util.*;
import java.math.*;

public class Main
{
    static BigInteger fact(int s,int e){
        BigInteger ans = new BigInteger("1");
        
        for(int i=s;i<=e;i++){
            ans = ans.multiply(new BigInteger(String.valueOf(i)));
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		System.out.println(fact(M+1,N).divide(fact(1,N-M)));
	}
}