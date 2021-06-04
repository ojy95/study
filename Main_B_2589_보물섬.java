package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2589_보물섬 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int map[][] = new int[row][col];
		
		for(int i=0;i<row;i++) {
			String tmp = br.readLine();
			for(int j=0;j<col;j++) {
				if(tmp.charAt(j)=='L') {
					map[i][j] = 1;
				}
			}
		}
		boolean check[][];
		Queue<Spot> queue = new LinkedList<Spot>();
		int dy[] = {1,0,-1,0}, dx[] = {0,1,0,-1};
		int result=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(map[i][j]==1) {
					check = new boolean[row][col];
					check[i][j] = true;
					queue.add(new Spot(i,j));
					int len=-1;
					while(!queue.isEmpty()) {
						len++;
						int size = queue.size();
						for(int l=0;l<size;l++) {
							Spot tmp = queue.poll();
							for(int k=0;k<4;k++) {
								int my = tmp.y+dy[k];
								int mx = tmp.x+dx[k];
								if(my<0||mx<0||my>=row||mx>=col||map[my][mx]==0||check[my][mx]) {
									continue;
								}
								check[my][mx]=true;
								queue.add(new Spot(my,mx));
							}
						}
					}
					if(result<len) {
						result=len;
					}
				}
			}
		}
		System.out.println(result);
	}

}
class Spot{
	int y,x;

	public Spot(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}