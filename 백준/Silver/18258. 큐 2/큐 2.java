import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()); 

        int lastValue = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    int value = Integer.parseInt(input[1]);
                    queue.offer(value);
                    lastValue = value;
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.poll() + "\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(lastValue).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}