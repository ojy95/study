package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1937_욕심쟁이판다 {
	static int[][] map;
	static int[][] maxmap;
	static boolean[][] check;
	static int[] dy= {-1,1,0,0}, dx= {0,0,-1,1}; //상하좌우
	static int result=1;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n+2][n+2];
		maxmap = new int[n+2][n+2];
		check = new boolean[n+2][n+2];
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<n+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxmap[i][j]=1;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(!check[i][j]) {
					search(i,j,1);
					if(result<maxmap[i][j]) {
						result = maxmap[i][j];
					}					
				}
			}	
		}
		System.out.println(result);
		
		

	}
	private static int search(int y, int x, int c) {
		if(check[y][x]) {
			return maxmap[y][x];
		}
		check[y][x] = true;
		int max[] = new int[4];
		for(int i=0;i<4;i++) {
			int moveY = y+dy[i], moveX = x+dx[i];
			if(moveY == 0 || moveY == n+1 || moveX == 0 || moveX == n+1) {
				continue;
			}
			if(map[moveY][moveX]>map[y][x]){
				max[i] = search(moveY, moveX, c+1);
			}

		}
		for(int i=0;i<4;i++) {
			if(max[i]!=0 && maxmap[y][x]<max[i]+1) {
				maxmap[y][x] = max[i]+1;
			}
		}
		
		return maxmap[y][x];
		
		
	}

}
