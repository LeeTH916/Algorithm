import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		int tmp;
		while(true) {
			tmp = queue.poll();
			if(queue.isEmpty()) break;
			queue.add(queue.poll());
		}
		System.out.println(tmp);
	}

}
