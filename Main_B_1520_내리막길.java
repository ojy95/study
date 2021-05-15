package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1520_내리막길 {
	static int M,N,map[][],dy[]= {1,0,-1,0}, dx[]= {0,1,0,-1},success[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		success = new int[M][N];
		for(int i=0;i<M;i++) {
			Arrays.fill(success[i], -1);			
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		search(0,0);
		System.out.println(success[0][0]);
	}
	private static int search(int col, int row) {
		if(col==M-1 && row==N-1) {
			return 1;
		}
		int count=0;
		for(int i=0;i<4;i++) {
			int y= col+dy[i];
			int x= row+dx[i];
			if(y<0|| y>M-1||x<0|| x>N-1) {
				continue;
			}
			if(map[y][x]<map[col][row]) {
				if(success[y][x]!=-1) {
					count+=success[y][x];
					continue;
				}
				count+=search(y,x);
			}
		}
		success[col][row]=count;
		return count;
		
	}

}
