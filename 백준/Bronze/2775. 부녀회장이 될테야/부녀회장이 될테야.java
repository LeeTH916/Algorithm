import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] apart = new int[15][14];
		
		
		for(int i=0;i<15;i++){
		    for(int j=0;j<14;j++){
		        if(i==0){
		            apart[i][j] = j + 1;
		        } else {
		            if(j==0) apart[i][j] = 1;
		            else {
		                apart[i][j] = apart[i-1][j] + apart[i][j-1];
		            }
		        }
		    }
		}
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++){
		    int k,n;
		    k = sc.nextInt();
		    n = sc.nextInt();
		    
		    System.out.println(apart[k][n-1]);
		}
	}
}
