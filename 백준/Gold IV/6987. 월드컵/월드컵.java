import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int flag;
	static int[][] list = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},
			{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
	static Country[] result;
	static Country[] team;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<4;i++) {
			result = new Country[6];
			team = new Country[6];
			flag = 0;
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				result[j] = new Country();
				team[j] = new Country();
				result[j].w = Integer.parseInt(st.nextToken());
				result[j].d = Integer.parseInt(st.nextToken());
				result[j].l = Integer.parseInt(st.nextToken());
			}
			solve(0);
			System.out.print(flag + " ");
		}
	}
	
	static void solve(int cnt) {
		if(flag == 1) return;
		if(cnt == 15) {
			for(int i=0;i<6;i++) {
				if(result[i].w != team[i].w ||
						result[i].d != team[i].d || result[i].l != team[i].l) return;
			}
			flag = 1;
			return;
		}
		
		int a = list[cnt][0];
		int b = list[cnt][1];
		
		team[a].w++; team[b].l++;
		solve(cnt+1);
		team[a].w--; team[b].l--;
		
		team[a].d++; team[b].d++;
		solve(cnt+1);
		team[a].d--; team[b].d--;
		
		team[a].l++; team[b].w++;
		solve(cnt+1);
		team[a].l--; team[b].w--;	
	}
}

class Country {
	int w;
	int d;
	int l;
}