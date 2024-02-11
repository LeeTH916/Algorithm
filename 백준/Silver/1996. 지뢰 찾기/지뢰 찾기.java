import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map,ans;
    static int[] x = {-1,-1,0,1,1,1,0,-1};
    static int[] y = {0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                if(str.charAt(j) == '.') map[i][j] = 0;
                else map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0) sb.append('*');
                else {
                    check(i,j);
                    if(ans[i][j] >= 10) sb.append('M');
                    else sb.append(ans[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void check(int _y,int _x){
        for(int i=0;i<8;i++){
            int next_y = _y + y[i];
            int next_x = _x + x[i];

            if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N) continue;

            ans[_y][_x] += map[next_y][next_x];
        }
    }
}