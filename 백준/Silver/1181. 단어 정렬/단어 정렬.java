import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] list = new String[N];
		
		for(int i=0;i<N;i++){
		    list[i] = sc.next();
		}
		
		Set<String> set = new HashSet<>(Arrays.asList(list));
		list = set.toArray(new String[0]);
		
		Arrays.sort(list,(a,b)-> a.length() != b.length() ? 
		a.length() - b.length() : a.compareTo(b));
		
		for(String str : list){
		    System.out.println(str);
		}
	}
}
