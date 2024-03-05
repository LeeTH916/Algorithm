import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Time> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Time(a,b));
		}
		
		Collections.sort(list);
		
		int end = 0;
		int answer = 0;
		for(int i=0;i<N;i++) {
			if(end <= list.get(i).start) {
				end = list.get(i).end;
				answer++;
			}
		}
		System.out.println(answer);
	}
}

class Time implements Comparable<Time> {
	int start,end;

	public Time(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if(this.end == o.end) return Integer.compare(this.start, o.start); 
		return Integer.compare(this.end, o.end);
	}
}
