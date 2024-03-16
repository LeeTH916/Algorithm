import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new HashMap<>(); 

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];

            if(status.equals("enter")) {
                map.put(name, true);
            } else {
                map.remove(name);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for(String name : list) {
            if(map.get(name)) {
                System.out.println(name);
            }
        }
    }
}