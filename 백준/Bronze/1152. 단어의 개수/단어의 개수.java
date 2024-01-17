import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int cnt = 0;
		String str = sc.nextLine();
		String[] result = str.split(" ");
		
		for(String tmp : result)
		    if(!tmp.isEmpty()) cnt ++;

		System.out.println(cnt);
	}
}
