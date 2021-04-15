package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B_2580_스도쿠 {
	static int map[][]= new int[9][9], count=0;
	static LinkedList<Empty> list = new LinkedList<Empty>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new Empty(i,j));
					count++;
				}
			}
		}
		solve(0);
	}
	private static void solve(int p) {
		if(p==count) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int x = list.get(p).x, y = list.get(p).y;
		for(int i=1;i<10;i++) {
			if(possible(y,x,i)) {
				map[y][x] = i;
				solve(p+1);
				map[y][x]=0;
			}
		}
		return;
	}
	private static boolean possible(int y, int x, int n) {
		int row = y/3*3, col = x/3*3;
		for(int i=0;i<9;i++) {
			if(map[y][i]==n || map[i][x]==n) {
				return false;
			}
		}
		for(int i=row;i<row+3;i++) {
			for(int j=col;j<col+3;j++) {
				if(map[i][j]==n) {
					return false;
				}
			}
		}
		return true;
	}
}

class Empty{
	int y;
	int x;
	public Empty(int y, int x) {
		this.y = y;
		this.x = x;
	}
}