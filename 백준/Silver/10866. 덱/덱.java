import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.getFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.getLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
