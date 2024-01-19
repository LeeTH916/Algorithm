import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    int SIZE = 8;
	    int cnt = 0;
	    
	    for(int i=0;i<SIZE;i++){
	        String line = sc.nextLine();
	        for(int j=0;j<SIZE;j++){
	            if((i+j)%2==0){
	                char c = line.charAt(j);
	                if(c == 'F') cnt++;
	            }
	            
	        }
	    }
	    
	    System.out.println(cnt);
	}
}
