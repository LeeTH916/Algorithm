import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (queue.isEmpty()) System.out.println("-1");
                    else System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (queue.isEmpty()) System.out.println("-1");
                    else System.out.println(queue.peek());
                    break;
                case "back":
                    if (queue.isEmpty()) System.out.println("-1");
                    else System.out.println(((LinkedList<Integer>)queue).getLast());
                    break;
            }
        }
    }
}
