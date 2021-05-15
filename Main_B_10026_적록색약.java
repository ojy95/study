package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_10026_적록색약 {
	static int map[][], N,result1,result2, dy[]= {1,0,-1,0}, dx[]= {0,1,0,-1};
	static boolean check[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				char c = tmp.charAt(j);
				if(c=='R') {
					map[i][j]=1;
				}else if(c=='G') {
					map[i][j]=2;					
				}else {
					map[i][j]=3;										
				}
			}
		}
		
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				serach(i,j);				
			}
		}
		result1= result2;
		result2=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==2) {			
					map[i][j]=1;
				}
			}
		}
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				serach(i,j);				
			}
		}
		
		System.out.println(result1+" "+result2);
	}
	private static void serach(int col, int row) {
		if(check[col][row]) {
			return;
		}
		result2++;
		check[col][row] = true;
		search2(col,row);
	}
	private static void search2(int col, int row) {
		for(int i=0;i<4;i++) {
			int y= col+dy[i];
			int x= row+dx[i];
			if(y<0|| y>N-1||x<0|| x>N-1 || check[y][x]) {
				continue;
			}
			if(map[y][x] == map[col][row]) {
				check[y][x] = true;
				search2(y,x);
			}
			
		}
		
	}
}
