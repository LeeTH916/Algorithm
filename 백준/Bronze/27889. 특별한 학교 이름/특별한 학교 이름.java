import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static HashMap<String,String> map = new HashMap<>();
    public static void main(String[] args) {
    	map.put("NLCS", "North London Collegiate School");
    	map.put("BHA", "Branksome Hall Asia");
    	map.put("KIS", "Korea International School");
    	map.put("SJA", "St. Johnsbury Academy");
    	
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(map.get(str));
		
	}
}