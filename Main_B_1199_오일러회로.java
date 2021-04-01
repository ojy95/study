package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1199_오일러회로 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=1;i<N+1;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0)	map[i][0] += map[i][j];
			}
		}
		boolean success = true;
		for(int i=1;i<N+1;i++) {
			if(map[i][0]%2==1) {
				success = false;
				break;
			}
		}
		if(success) {
			search(1);
		}else {
			System.out.println(-1);
		}
	}

	private static void search(int now) {
		for(int i=1;i<N+1;i++) {
			while(map[now][i]>0) {
				map[now][i]--;
				map[i][now]--;
				search(i);
			}
		}
		System.out.print(now+" ");
	}

}



