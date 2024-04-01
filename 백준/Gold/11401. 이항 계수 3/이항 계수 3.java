import java.util.Scanner;
 
public class Main {
    static int p = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N,R;
        N = sc.nextInt();
        R = sc.nextInt();
         
        long answer = factorial(N) * pow(factorial(R) * factorial(N-R) % p, p-2) % p;
        System.out.println(answer);
        
    }
     
    static long factorial(int n) {
        long v = 1;
        for(int i=1;i<=n;i++) {
            v = (v*i)%p;
        }
        return v;
    }
     
    static long pow(long v, int n) {
        if(n==0) return 1;
        else if(n==1) return v;
        else {
            long tmp = pow(v,n/2) % p;
            if(n%2==1) return (tmp * tmp)%p * v % p;
            else return tmp * tmp %p;
        }
    }
}