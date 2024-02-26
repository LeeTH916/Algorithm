import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Point> list,upList;
    static List<Integer>[] map;
    static int[] visited;
    static Point end;
    static int a,b;
    static int flag;
    static int v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        upList = new ArrayList<>();
        visited = new int[N];
        map = new List[N];
        for(int i=0;i<N;i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y,i));
        }

        for(int i=0;i<N;i++) {
            Point cur = list.get(i);
            Point next = list.get((i+1)%N);

            if(cur.y * next.y <0) {
                if(cur.y >= 0) {
                    next.y = 0;
                    upList.add(next);
                }
                else {
                    cur.y = 0;
                    upList.add(cur);
                }
            } else if(cur.y <= 0 && next.y <= 0) continue;

            map[i].add((i+1)%N);
            map[(i+1)%N].add(i);
        }

        Collections.sort(upList, (a,b) -> a.x-b.x);

        a = b = 0;
        v = 1;

        for(int i=0;i<upList.size();i++) {
            Point cur = upList.get(i);

            if(visited[cur.i] == 0) {
                visited[cur.i] = v;
                doDFS(cur.i);
                v++;
            }

        }
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for(int i=0;i<upList.size();i++) {
            Point cur = upList.get(i);
            if(stack.isEmpty()) {
                a++;
                stack.push(visited[cur.i]);
                flag = 1;
            } else {
                if(stack.peek() != visited[cur.i]) {
                	stack.push(visited[cur.i]);
                	flag = 1;
                } else {
                	stack.pop();
                	if(flag == 1) b++;
                	flag = 0;
                }
            }


        }

        System.out.println(a + " " + b);
    }

    static void doDFS(int i) {

        for(int k=0;k<map[i].size();k++) {
            int next = map[i].get(k);
            if(visited[next] == 0) {
                visited[next] = v;
                if(list.get(next).y == 0) return;
                doDFS(next);
            }
        }
    }
}

class Point{
    int x,y,i;

public Point(int x, int y, int i) {
    super();
    this.x = x;
    this.y = y;
    this.i = i;
}

@Override
public String toString() {
    return "Point [x=" + x + ", y=" + y + ", i=" + i + "]";
}
}