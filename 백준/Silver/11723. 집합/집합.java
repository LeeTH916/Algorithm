import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            int x = 0;

            switch (command[0]) {
                case "add":
                    x = Integer.parseInt(command[1]) - 1;
                    set |= (1 << x);
                    break;
                case "remove":
                    x = Integer.parseInt(command[1]) - 1;
                    set &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(command[1]) - 1;
                    sb.append((set & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(command[1]) - 1;
                    set ^= (1 << x);
                    break;
                case "all":
                    set = (1 << 20) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
